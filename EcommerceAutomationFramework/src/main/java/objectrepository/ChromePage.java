package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class ChromePage extends BaseClass{

@FindBy(name="q")
private WebElement searchTF;

public ChromePage(AndroidDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getSearchTF() {
	return searchTF;
}


}
