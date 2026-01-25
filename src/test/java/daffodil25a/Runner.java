package daffodil25a;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources",
		glue = {"com.skillio"},
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

}
