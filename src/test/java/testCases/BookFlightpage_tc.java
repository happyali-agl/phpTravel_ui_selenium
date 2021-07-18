package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import teststeps.BookFlight;
import teststeps.Homepage;
import teststeps.Searchpage;
import utility.CommonFunctions;

@Listeners(utility.CustomListeners.class)
public class BookFlightpage_tc extends CommonFunctions {

	@Test(description = "Login To Book A Flight")
	public void loginForFlightBookPage() throws Throwable {		
		Reporter.log("Before Login for Search page test", true);
		loginPage(driver);
		Homepage.submitLogin(driver);
		Homepage.verifyUsername(driver);
		Reporter.log("\nAfter Login for Search page test", true);
	}
	
	@Test(description = "Navigate To Flight Page", dependsOnMethods = { "loginForFlightBookPage" })
	public void navigateToFlightPage() throws Throwable {		
		Searchpage.navigateToHome(driver);
		Searchpage.navigateToFlight(driver);
		Reporter.log("After Navigating to Flight Tab", true);
	}
	
	@Test(description = "Selecting Flight Class", dependsOnMethods = { "loginForSearchPage" })
	public void selectFlightClass() throws Throwable {		
		BookFlight.selectClass(driver);
	}	
	
	@Test(description = "Selecting Flight Source", dependsOnMethods = { "selectFlightClass" })
	public void selectSource() throws Throwable {		
		BookFlight.selectFlightSource(driver);
		BookFlight.selectFlightDestination(driver);
	}	
}
