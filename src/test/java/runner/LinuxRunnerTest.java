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
		
		,tags =  "@BuyProductwithbank_partnerpanel or @BuyProductwithpaypal_partnerpanel or @Adding_Credit_Limit_In_Customer_Account_partnerpanel "
				+ "or @Adding_Credit_Balance_in_Customer_Account_partnerpanel or @Adding_receipt_to_pay_invoice_paid_by_banking_gateway_partnerpanel"
		
		)


public class LinuxRunnerTest {

}
