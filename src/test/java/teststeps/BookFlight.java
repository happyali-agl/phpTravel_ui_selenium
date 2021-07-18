package teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import testCases.BookFlightpage_tc;
import testCases.Homepage_tc;
import testCases.Searchpage_tc;

@Listeners(utility.CustomListeners.class)
public class BookFlight extends BookFlightpage_tc {
	
	public static WebDriver navigateToFlight(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Navigating to Flight Tab ", true);
		isElementPresent("search_flights_CSS");
		driver.findElement(By.cssSelector(".text-center.flights")).click();
		click("search_flights_CSS");
		isElementPresent("oneway_trip_CSS");
		return driver;
	}
	
	public static WebDriver selectClass(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Selecting to Flight Class", true);
		isElementPresent("selectClass_CSS");
//		click("selectClass_CSS");
//		select("selectClass_CSS","Business");
//		Select se = new Select(driver.findElement(By.cssSelector("select[name='cabinclass']")));
//		se.selectByVisibleText("Business");
//		Thread.sleep(5000);
		return driver;
	}
	
	public static WebDriver selectFlightSource(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Selecting to Flight Source", true);
		click("flightFrom_CSS");
		type("flightFrom_port_CSS","SYD");
		driver.findElement(By.cssSelector(config.getFromObjectRepo("flightFrom_port_CSS"))).sendKeys(Keys.ENTER);
		Reporter.log("\nAfter Selecting to Flight Source", true);
		return driver;
	}
	
	public static WebDriver selectFlightDestination(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Selecting to Flight Destination", true);
		driver.findElement(By.cssSelector(config.getFromObjectRepo("flightFrom_port_CSS"))).sendKeys(Keys.TAB);
//		click("flightTo_ID");
		type("flightTo_port_CSS","MEL");
		driver.findElement(By.cssSelector(config.getFromObjectRepo("flightTo_port_CSS"))).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Reporter.log("\nAfter Selecting to Flight Destination", true);
		return driver;
	}
	
}
