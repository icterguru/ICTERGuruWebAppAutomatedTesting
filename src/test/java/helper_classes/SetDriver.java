package helper_classes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SetDriver {
	public static WebDriver webDriver;
	public String browser;


	/**
	 * Will create a new WebDriver for the desired browser  
	 */
	
	@Before
	public void getBrowser(Scenario scenario) throws Exception {
//		System.out.println("Before test....");
		
//		browser = GlobalSettings.getInstance().getProperty("BROWSER");
//		System.out.println("Selected browser is: " + browser);

		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  // For Windows
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");  // For Mac
			webDriver = new ChromeDriver();
			
		}
	
	@After
	public void afterTest(Scenario scenario) {
		System.out.println("After test....");
		try {
			deleteCookies(webDriver);
			webDriver.quit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void deleteCookies(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.manage().deleteAllCookies();
        if (!cookies.isEmpty()) {
            System.out.println(cookies.size());
            Iterator<Cookie> iter= driver.manage().getCookies().iterator();
            while(iter.hasNext()){
                Cookie c = iter.next();
              //  System.out.println(c.getName()+"\n" + c.getPath()+"\n"+ c.getDomain()+"\n"+ c.getValue()+"\n"+ c.getExpiry());
            }
            cookies.clear();
            System.out.println(cookies.size());
        }
    }
}