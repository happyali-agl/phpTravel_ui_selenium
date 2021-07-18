package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import teststeps.Homepage;
import teststeps.Searchpage;
import utility.CommonFunctions;

@Listeners(utility.CustomListeners.class)
public class Searchpage_tc extends CommonFunctions {

	@Test(description = "Login For Search Page")
	public void loginForSearchPage() throws Throwable {		
		Reporter.log("Before Login for Search page test", true);
		loginPage(driver);
		Homepage.submitLogin(driver);
		Homepage.verifyUsername(driver);
		Reporter.log("After Login for Search page test", true);
	}
	
	@Test(description = "Navigate To Home Page", dependsOnMethods = { "loginForSearchPage" })
	public void navigateToHomepage() throws Throwable {		
		Searchpage.navigateToHome(driver);
	}
	
	@Test(description = "Navigate to Flight Page", dependsOnMethods = { "navigateToHomepage" })
	public void navigateToFlightPage() throws Throwable {		
		Searchpage.navigateToFlight(driver);
	}
}
