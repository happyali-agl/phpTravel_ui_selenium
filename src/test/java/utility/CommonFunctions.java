package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pages.BaseClass;

public class CommonFunctions extends BaseClass {

	public WebDriver loginPage(WebDriver driver) throws Throwable {
		driver.get(config.getFromConfig("loginUrl"));
		isElementPresent("logo_XPATH");
		return driver;
	}

	public static void click(String key) throws Throwable {
		String searchElement = null;
		WebElement elementToClick = null;
		WebDriverWait clickWait = new WebDriverWait(driver, 10);
		try {
			if (key.startsWith("//")) {
				searchElement = key;
				elementToClick = clickWait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchElement)));
			} else if (key.endsWith("_CSS")) {
				searchElement = config.getFromObjectRepo(key);
				elementToClick = clickWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(searchElement)));
			} else {
				searchElement = config.getFromObjectRepo(key);
				elementToClick = clickWait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchElement)));
			}
			elementToClick.click();
			Reporter.log("Element Clicked : " + key, true);
		} catch (Exception e) {
			Reporter.log("No Element To Click : " + key, true);
			e.printStackTrace();
		}
	}
	
	public static boolean isElementPresent(String key) {
		String presentElement = null;
		WebDriverWait presentWait = new WebDriverWait(driver, 10);
		try {
			if (key.startsWith("//")) {
				presentElement = key;
				presentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(presentElement)));				
			} else if (key.endsWith("_CNAME")) {
				presentElement = config.getFromObjectRepo(key);
				presentWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(presentElement)));				
			} else if (key.endsWith("_CSS")) {
				presentElement = config.getFromObjectRepo(key);
				presentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(presentElement)));				
			} else {
				presentElement = config.getFromObjectRepo(key);
				presentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(presentElement)));				
			}
			Reporter.log("ELEMENT IS FOUND :" + key, true);
			return true;
		} catch (Throwable e) {
			Reporter.log("ELEMENT NOT FOUND :" + key, true);
			return false;
		}
	}

	public static void select(String key, String value) throws Throwable {

		WebElement dropdown = null;

		try {
			if (key.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(config.getFromObjectRepo(key)));
			} else if (key.endsWith("_ID")) {
				dropdown = driver.findElement(By.id(config.getFromObjectRepo(key)));
			} else if (key.endsWith("_CSS")) {
				dropdown = driver.findElement(By.cssSelector(config.getFromObjectRepo(key)));
			} else if (key.endsWith("_CNAME")) {
				dropdown = driver.findElement(By.className(config.getFromObjectRepo(key)));
			}
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			Reporter.log("ELEMENT NOT FOUND TO SELECT :" + key, true);
			e.printStackTrace();
		}
	}
	
	public static void type(String key, String value) throws Throwable {
		try {
			if (key.endsWith("_XPATH")) {
				driver.findElement(By.xpath(config.getFromObjectRepo(key))).sendKeys(value);
			} else if (key.endsWith("_ID")) {
				driver.findElement(By.id(config.getFromObjectRepo(key))).sendKeys(value);
			} else if (key.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(config.getFromObjectRepo(key))).sendKeys(value);
			} else {
				driver.findElement(By.xpath(config.getFromObjectRepo(key))).sendKeys(value);
			}
			Reporter.log(key+ " :Typed Element ", true);
		} catch (Exception e) {
			Reporter.log("No Element To type at : " + key, true);
			e.printStackTrace();
		}
	}
	
}
