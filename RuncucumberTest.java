package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		dryRun = false,
		features = {"src/test/java/features/DeleteLead.feature"},
		glue = {"stepDefintion"},
		monochrome = true
		
		)

public class RuncucumberTest extends AbstractTestNGCucumberTests {

	
}
