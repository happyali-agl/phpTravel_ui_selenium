package testCases;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import teststeps.Homepage;
import utility.CommonFunctions;

@Listeners(utility.CustomListeners.class)
public class Homepage_tc extends CommonFunctions {

	@Test(description = "Launch PHP Travels Demo Site")
	public void launchingLoginPage() throws Throwable {
		Reporter.log("Before Launching Demo Test site", true);
		loginPage(driver);
	}

	@Test(description = "Verify Search Widget",dependsOnMethods = { "launchingLoginPage" })
	public static void submitLoginCredentials() throws Throwable {
		Homepage.submitLogin(driver);
	}
	
	@Test(description = "Verify User Welcome Message",dependsOnMethods = { "submitLoginCredentials" })
	public static void verifyUserDashboard() throws Throwable {
		Homepage.verifyUsername(driver);
	}
}
