package teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import testCases.Homepage_tc;
import testCases.Searchpage_tc;

@Listeners(utility.CustomListeners.class)
public class Searchpage extends Searchpage_tc {
	
	public static WebDriver navigateToHome(WebDriver driver) throws Throwable {
		Reporter.log("Before Navigating to Home page", true);
		driver.findElement(By.cssSelector("a[title='home']")).click();
		isElementPresent("search_hotels_CSS");
		Reporter.log("After Navigating to Home page", true);
		return driver;
	}
	
	public static WebDriver navigateToFlight(WebDriver driver) throws Throwable {
		Reporter.log("Before Navigating to Flight Tab ", true);
		isElementPresent("search_flights_CSS");
		driver.findElement(By.cssSelector(".text-center.flights")).click();
		click("search_flights_CSS");
		isElementPresent("oneway_trip_CSS");
		Reporter.log("After Navigating to Flight Tab", true);
		return driver;
	}
}
