package teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import testCases.Homepage_tc;

@Listeners(utility.CustomListeners.class)
public class Homepage extends Homepage_tc {
	
	public static WebDriver submitLogin(WebDriver driver) throws Throwable {
		Reporter.log("Before Submitting Login Credentials", true);
		type("login_email_XPATH", config.getFromConfig("user"));
		type("login_password_XPATH", config.getFromConfig("password"));
		click("login_submit_button");
		Reporter.log("After Submitting Login Credentials", true);
		return driver;
	}
	
	public static WebDriver verifyUsername(WebDriver driver) throws Throwable {
		Reporter.log("Before Verifying User dashboard", true);
		WebElement divElement = driver.findElement(By.className("text-align-left"));
		String str = divElement.getText();
		System.out.println(str);
		Assert.assertEquals(str, config.getFromData("UsernameWelcome"));
		Reporter.log("After Verifying User name in dashboard", true);
		return driver;
	}
}
