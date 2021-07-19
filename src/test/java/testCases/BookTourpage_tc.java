package testCases;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import teststeps.BookTour;
import teststeps.Homepage;
import teststeps.Searchpage;
import utility.CommonFunctions;

@Listeners(utility.CustomListeners.class)
public class BookTourpage_tc extends CommonFunctions {

	@Test(description = "Login To Book A Tour")
	public void loginForBookTourPage() throws Throwable {		
		Reporter.log("Before Login for Book Tour page test", true);
		loginPage(driver);
		Homepage.submitLogin(driver);
		Homepage.verifyUsername(driver);
		Reporter.log("\nAfter Login for Book Tour page test", true);
	}
	
	@Test(description = "Navigate To Tour Page", dependsOnMethods = { "loginForBookTourPage" })
	public void navigateToTourPage() throws Throwable {	
		Searchpage.navigateToHome(driver);
		BookTour.navigateToTour(driver);
		Reporter.log("After Navigating to Tour Tab", true);
	}
	
	@Test(description = "Selecting Tour", dependsOnMethods = { "navigateToTourPage" })
	public void selectTourPage() throws Throwable {		
		BookTour.selectTour(driver);
		Reporter.log("After Submitting to Tour Tab", true);
	}	
	
	@Test(description = "Selecting Check Date", dependsOnMethods = { "selectTourPage" })
	public void selectTourCheckInPage() throws Throwable {		
		BookTour.selectTourCheckIn(driver);
		Reporter.log("After Submitting to Tour Tab", true);
	}
}
