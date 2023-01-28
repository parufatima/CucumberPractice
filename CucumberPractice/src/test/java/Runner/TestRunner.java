package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/The Fetures"},
plugin = {"json:target/cucumber.json"},
glue = "StepDeffination",tags = {"@PaychexWindowHandle"})


public class TestRunner extends AbstractTestNGCucumberTests {

}
