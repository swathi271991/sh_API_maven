package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.specification.RequestSpecification;
import resources.Dependency;
import resources.Utils;

public class GetPlaceStepDefination extends Utils{
	
	public RequestSpecification httpreq;
	public Dependency dpn;
	
	public GetPlaceStepDefination(Dependency dpn)
	{
		this.dpn = dpn;
	}

    @Then("^Then API call should be successfull with status code 200$")
    public void then_api_call_should_be_successfull_with_status_code_200() throws Throwable {
     
    	System.out.println(Dependency.getresp.getAddress());
    	
    }
    

    @And("^Response should be displayed$")
    public void response_should_be_displayed() throws Throwable {
    	
        System.out.println(Dependency.getresp.getWebsite());
    }


}
