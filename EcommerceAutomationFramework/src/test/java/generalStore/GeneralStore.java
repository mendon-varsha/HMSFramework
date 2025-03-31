
package generalStore;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import genericUtility.BaseClass;
import genericUtility.ListenerImplementation;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import objectrepository.CartPage;
import objectrepository.ChromePage;
import objectrepository.LoginPage;
import objectrepository.ProductsPage;
@Listeners(ListenerImplementation.class)
public class GeneralStore extends BaseClass {
	@Test
	public void generalStore() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getAddToCartLink().click();
		productsPage.getCartButton().click();
		CartPage cartPage = new CartPage(driver);
		cartPage.getVisitWebsiteLink().click();

		Thread.sleep(6000);
		Set<String> contextHandles = driver.getContextHandles();
		System.out.println(contextHandles.size());

		for (String ch : contextHandles) {
			System.out.println(ch);
		}
		Thread.sleep(5000);

		driver.context(fu.readDataFromPropertyFile("context"));
		ChromePage chromePage = new ChromePage(driver);
		chromePage.getSearchTF().sendKeys(fu.readDataFromPropertyFile("searchValue"), Keys.ENTER);

	}

}
