package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {

@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")
private WebElement addToCartLink;

@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]")
private WebElement cartButton;

public ProductsPage(AndroidDriver driver) {
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

public WebElement getAddToCartLink() {
	return addToCartLink;
}

public WebElement getCartButton() {
	return cartButton;
}
}
