package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		switch (browserName.toLowerCase()) {
		case "chrome":
//			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
//			WebDriverManager.chromedriver().version("2.36")setup(); 	// for specific version
//			WebDriverManager.chromedriver().setup(); 				// for latest
//			driver = new ChromeDriver();
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_setting_values.notifications", 2);	// 2 means block notifications
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("prefs", prefs);
//			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//			options.addArguments("--disable-extensions");
//			options.addArguments("--disable-infobars");
			WebDriverManager.chromedriver().setup(); // for latest
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			System.out.println("Browser is set as Chrome");
			break;
		case "firefox":
			// NOTE: Firefox must be installed under "C:\Program Files (x86)\Mozilla
			// Firefox\" path (not in Program Files)
			// System.setProperty("webdriver.gecko.driver",
			// "./src/test/resources/drivers/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Browser is set as Firefox");
			break;
		case "ie":
//			WebDriverManager.iedriver().setup();
			System.setProperty("webdriver.ie.driver", "./src/test/resources/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("Browser is set as IE");
			break;
		case "edge":
			System.out.println("Setting Browser as Edge");
//			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "./src/test/resources/drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			System.out.println("Browser is set as Edge");
			break;
		default:
			System.out.println("Looking forward to the Weekend");
		}
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Returning browser");
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}
}
