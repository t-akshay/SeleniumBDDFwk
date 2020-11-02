package runnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features = "src/test/java/featureFiles",
				glue = {"StepDefinitions", "runnerFiles"},
				strict=true,
				plugin={"pretty","html:target/Reports"})
public class RunTestNGTest extends AbstractTestNGCucumberTests {
	
}