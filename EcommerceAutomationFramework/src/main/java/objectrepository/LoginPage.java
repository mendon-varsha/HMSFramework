package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1']")
private WebElement searchDropDown;

@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")
private WebElement nameTextField;

@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioFemale']")
private WebElement femaleRadioButton;

@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.androidsample.generalstore:id/btnLetsShop']")
private WebElement letsShopButton;

@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"India\"))")
private WebElement countryDropDown;

public LoginPage(AndroidDriver driver) {
	PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}

public WebElement getSearchDropDown() {
	return searchDropDown;
}

public WebElement getNameTextField() {
	return nameTextField;
}

public WebElement getFemaleRadioButton() {
	return femaleRadioButton;
}

public WebElement getLetsShopButton() {
	return letsShopButton;
}

public WebElement getCountryDropDown() {
	return countryDropDown;
}


}
