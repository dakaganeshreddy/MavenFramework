package pompages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="username")
	WebElement unObj;
	@FindBy(name="pwd")
	WebElement pwdObj;
	@FindBy(xpath="//div[text()='Login ']")
	WebElement loginBtnObj;
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	public void setUserName(String username)
	{
		unObj.sendKeys(username);
	}
	public void setPassword(String pwd)
	{
		pwdObj.sendKeys(pwd);
	}
	public void clickLogin() {
		loginBtnObj.click();
	}
}
