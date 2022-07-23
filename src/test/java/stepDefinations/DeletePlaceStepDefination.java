package stepDefinations;

import io.cucumber.java.en.Then;
import resources.Dependency;


public class DeletePlaceStepDefination {



	@Then("^validate the place id has been deleted$")
	public void validate_the_place_id_has_been_deleted() throws Throwable {
		
		System.out.println(Dependency.deleteresp.getStatus());

	}

}
