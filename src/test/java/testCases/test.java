package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.CommonFunctions;

@Listeners(utility.CustomListeners.class)
public class test extends CommonFunctions {
	
	@Test
	public void testDropdown() throws InterruptedException {
		driver.get("https://demoqa.com/select-menu");
		Select se = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		se.selectByIndex(3);
		Thread.sleep(5000);
		se.selectByValue("7");
		Thread.sleep(5000);
		se.selectByVisibleText("White");
		Thread.sleep(5000);
		}

}
