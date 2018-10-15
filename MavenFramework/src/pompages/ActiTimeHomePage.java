package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimeHomePage {
@FindBy(xpath="//div[@class='popup_menu_icon support_icon']")
WebElement helpBttn;

@FindBy(xpath="//a[text()='About your actiTIME']")
WebElement aboutHomePage;
@FindBy(xpath="//span[contains(text(),'actiTIME 2017.4')]")
WebElement actiVersion;
public ActiTimeHomePage(WebDriver driver)
{
	
	PageFactory.initElements(driver, this);
}
public void clickHelp() {
	helpBttn.click();
}
public void clickAboutActiTime() {
	aboutHomePage.click();
}
public String getVersionText()
{
	String productVersionText=actiVersion.getText();
	return productVersionText;
}
}
