package stepDefinations;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Dependency;

public class UpdatePlaceStepDefination {
	
	public RequestSpecification httpreq;
	public Response resp;

	@Then("^validate the updated address$")
	public void validate_the_updated_address() throws Throwable {
		
		System.out.println(Dependency.updateresp.getMsg());

	}


}
