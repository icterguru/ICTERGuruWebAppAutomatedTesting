package step_definitions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper_classes.SetDriver;

public class ICTERGuruHomePageLinksTest {

	private WebDriver driver;

	public ICTERGuruHomePageLinksTest() {
		driver = SetDriver.webDriver;

		//		new HomePage(driver);  // Used for POM model 
	} 


	@Given("^I launch the ICTERGuru WebApp home page$")
	public void i_launch_the_iCTERGuru_webApp_home_page() throws Throwable {
			driver.get("http://icterguru.herokuapp.com/");
			Thread.sleep(2000);   // temporary wait	   

	}
/*
	@And("^I scroll down to the end of the page$")
	public void i_scroll_down_to_the_end_of_the_page() throws Throwable {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);   // temporary wait	   

	}
*/
	
	@When("^I selected \"([^\"]*)\" link on the menu bar$")
	public void i_selected_link_on_the_menu_bar(String menuLink_text) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//		By linkedElement = By.xpath("//a[contains(text(),'" + menuLink_text + "')]");
		//		driver.findElement(linkedElement).click();
		//		or

		driver.findElement(By.linkText(menuLink_text)).click();

		Thread.sleep(2000);

	}

	@Then("^I verified the selected menu by the existence of the \"([^\"]*)\" text$")
	public void i_verified_the_selected_menu_by_the_existence_of_the_text(String linkedPage_text) throws Throwable {
			Assert.assertEquals(true, driver.getPageSource().contains(linkedPage_text));

	}


}
