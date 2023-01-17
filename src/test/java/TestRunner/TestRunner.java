package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"AllfeaturesFiles"},
		glue= {"StepDefination"},
		dryRun=false
		)
public class TestRunner {

}
