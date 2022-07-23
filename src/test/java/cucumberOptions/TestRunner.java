package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue = "stepDefinations",
		monochrome = true,
		tags ="@Test",
		plugin = {"pretty", "html:target/cucumber.html",
				"json:target/jsonReports/cucumberjs.json",
				"junit:target/cucumberfile.xml",
				"rerun:target/Failed_Scenario.txt"})
public class TestRunner {

}
