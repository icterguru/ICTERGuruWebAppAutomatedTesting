package runner_cukes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/",
		glue={"step_definitions", "runner_cukes", "helper_classes"},  // These two must be glued
		tags = {"@ICTERGuruHomePageLinksTest"},
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber-html_report", "junit:target/cucumber-junit-results.xml"}

		)


public class RunCukesTest extends AbstractTestNGCucumberTests {
	/*
	 *  Wired name?? Don't know. For more information please visit: https://cucumber.io/docs/reference/jvm#java
	 *   
	 * 
	 */

	@BeforeSuite
	public static void initializeSuite(ITestContext xmlSuite) throws FileNotFoundException, IOException {	
		System.out.println("Before Suite....");
		String suiteName = xmlSuite.getSuite().getName();
		//		ExtentReporter.startExtentReport(suiteName);

		InetAddress localHost;
		String hostIPAddress;
		try {
			localHost = InetAddress.getLocalHost();

			hostIPAddress = localHost.getHostAddress();
			
			System.out.println("Test Executing machine's Host IP Address: " + hostIPAddress);
	
		} catch (UnknownHostException e) {

			e.printStackTrace();

		}

	}


	@AfterSuite
	public static void afterSuite() {
		System.out.println("After Suite....");
		
		InetAddress localHost;
		String hostIPAddress;
		try {
			localHost = InetAddress.getLocalHost();

			hostIPAddress = localHost.getHostAddress();

			System.out.println("Test Executing machine's Host IP Address: " + hostIPAddress);
			
		} catch (UnknownHostException e) {

			e.printStackTrace();

		}

	}


}

