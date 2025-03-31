package genericUtility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import objectrepository.CartPage;
import objectrepository.ChromePage;
import objectrepository.LoginPage;
import objectrepository.ProductsPage;

public class BaseClass {
	public AndroidDriver driver;
	AppiumDriverLocalService sb;
	public static AndroidDriver sdriver;
	
	
	public FileUtility fu=new FileUtility();

	@BeforeSuite

	public void startServer() {
		File f = new File("C:\\Users\\admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		sb = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723)
				.withTimeout(Duration.ofSeconds(300)).build();
		sb.start();

	}

	@BeforeClass
	public void launchApplication() throws IOException {
		UiAutomator2Options option = new UiAutomator2Options();
		
		option.setPlatformName(fu.readDataFromPropertyFile("platformName"));
		option.setDeviceName(fu.readDataFromPropertyFile("deviceName"));
		option.setAutomationName(fu.readDataFromPropertyFile("automationName"));
		option.setUdid(fu.readDataFromPropertyFile("udid"));
		// option.setCapability("chromedriverAutodownload", true);

		URL url = new URL(fu.readDataFromPropertyFile("_url"));
		driver = new AndroidDriver(url, option);
		sdriver=driver;
		
	}

	@BeforeMethod
	public void login() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.activateApp(fu.readDataFromPropertyFile("appPackage"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getSearchDropDown().click();
		//gu.scroll(fu.readDataFromPropertyFile("country"));
		loginPage.getCountryDropDown().click();
		loginPage.getNameTextField().sendKeys(fu.readDataFromPropertyFile("name"));
		loginPage.getFemaleRadioButton().click();
		loginPage.getLetsShopButton().click();
	}

	@AfterClass
	public void logout() throws IOException {
		driver.terminateApp(fu.readDataFromPropertyFile("appPackage"));
	}

	@AfterSuite
	public void stopServer() {
		sb.close();
	}

}
