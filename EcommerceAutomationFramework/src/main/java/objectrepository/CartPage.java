package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]")
private WebElement visitWebsiteLink;

public CartPage(AndroidDriver driver) {
	PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	
	
}

public WebElement getVisitWebsiteLink() {
	return visitWebsiteLink;
}
}
