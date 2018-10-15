package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.IAutoConstant;
import generic.Lib;

import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void validLogin() throws InterruptedException
	{
	LoginPage page = new LoginPage(driver);
	String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
	String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
	//set username
	page.setUserName(un);
	Thread.sleep(5000);
	//set password
	page.setPassword(pw);
	Thread.sleep(5000);
	//click on valid login
	page.clickLogin();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));	
	SoftAssert s = new SoftAssert();
	s.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	s.assertAll();
}
}
