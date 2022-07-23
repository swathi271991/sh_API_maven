package stepDefinations;

import POJOclasses.AddPlaceBODY;
import POJOclasses.DeletePlaceResponsePoJO;
import POJOclasses.GetResponsePoJo;
import POJOclasses.ResponsePoJO;
import POJOclasses.UpdateResponsePoJo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import resources.Dependency;
import resources.PlaceAPI;
import resources.Utils;
import static io.restassured.RestAssured.*;

import org.junit.Assert;

public class AddPlaceStepDefination extends Utils {

	public RequestSpecification hp;
	public ResponsePoJO resp;
	public Dependency dpn;
	public GetResponsePoJo getresp;
	
	
	public AddPlaceStepDefination(Dependency dpn)
	{
		this.dpn = dpn;
	
	}

	@Given("^User has Add Place Payload$")
	public void user_has_add_place_payload() throws Throwable {
		

		hp = given().log().all().spec(request());
		System.out.println("From Y its Hi");

	}

	//Hi...Hellow...From GitHUB
	@When("^user calls \"([^\"]*)\" API using \"([^\"]*)\" http Request using (.+) (.+) and (.+)$")
    public void user_calls_something_api_using_something_http_request_using_and(String resource, String httpMethod, String name, String address, String phone) throws Throwable {

		PlaceAPI resourcename = PlaceAPI.valueOf(resource);

		System.out.println(resourcename.getresource());

		if(httpMethod.equalsIgnoreCase("POST"))
		{
			resp = hp.body(AddPlaceBODY.addPlace(name, address ,phone)).expect().defaultParser(Parser.JSON).
					when().post(resourcename.getresource())
					.then().spec(response()).log().all().extract().as(ResponsePoJO.class);
		}
		else if (httpMethod.equalsIgnoreCase("GET"))
		{
			Dependency.getresp = hp.queryParam("place_id", Dependency.place_id).expect().defaultParser(Parser.JSON).
					when().get(resourcename.getresource())
					.then().spec(response()).log().all().extract().as(GetResponsePoJo.class);
		}
		else if(httpMethod.equalsIgnoreCase("UPDATE"))
		{
			Dependency.updateresp = hp.body(AddPlaceBODY.updateplace(Dependency.place_id)).expect().defaultParser(Parser.JSON).
					when().put(resourcename.getresource())
					.then().spec(response()).log().all().extract().as(UpdateResponsePoJo.class);
		}
		else if(httpMethod.equalsIgnoreCase("DELETE"))
		{
			Dependency.deleteresp = hp.body(AddPlaceBODY.deleteplace(Dependency.place_id)).expect().defaultParser(Parser.JSON).
					when().delete(resourcename.getresource())
					.then().spec(response()).extract().as(DeletePlaceResponsePoJO.class);
		}
	}

	@Then("^API call should be successfull with status code 200$")
	public void api_call_should_be_successfull_with_status_code_200() throws Throwable {

         
		System.out.println(resp.getStatus());
		System.out.println("From Y its Hi");

	}

	@And("^\"([^\"]*)\" in the response should be \"([^\"]*)\"$")
	public void something_in_the_response_should_be_something(String status, String value) throws Throwable {

	
		Dependency.place_id = resp.getPlace_id();
		System.out.println(Dependency.place_id);
		System.out.println(resp.getScope());
		
		Assert.assertEquals(resp.getStatus(), value);

	}
	
	@Given("^User has an Add Place Payload$")
	public void user_has_an_add_place_payload() throws Throwable {
		
		if(Dependency.place_id==null)
		{
		user_has_add_place_payload();
		user_calls_something_api_using_something_http_request_using_and("AddPlace", "POST", "sairtyu", "bangalore", "12345676543");
		something_in_the_response_should_be_something("status", "OK");
		}
		else
		{
			user_has_add_place_payload();
		}
		
		
		

	}
	
}
