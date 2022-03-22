package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		dryRun = true,
		monochrome=true,
		features = "src/test/resources",
		glue={"features"},
		publish =true,
		plugin= {"pretty",
				"html:target/html-report/test-report",
				"junit:target/junit-xml-report.xml",
				"json:target/cucumber-report/json-report.json",
				
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		,tags = "@SubContact"
		)


public class LinuxRunnerTest {

}
