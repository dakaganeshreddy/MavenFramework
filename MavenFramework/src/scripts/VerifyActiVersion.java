package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.ActiTimeHomePage;
import pompages.LoginPage;

public class VerifyActiVersion extends BaseTest {
@Test
public void verifyActiTimeProductVersion() throws InterruptedException
{
	LoginPage page = new LoginPage(driver);
	String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
	String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
	//set username
	page.setUserName(un);
	Thread.sleep(5000);
	//set password
	page.setPassword(pw);
	page.clickLogin();
	ActiTimeHomePage atmp=new ActiTimeHomePage(driver);
	Thread.sleep(5000);
	atmp.clickHelp();
	Thread.sleep(3000);
	atmp.clickAboutActiTime();
	Thread.sleep(3000);
	String actulaActiVersion = atmp.getVersionText();
	String expectedResult = Lib.getPropertyValue("PRODUCTVERSION");
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(actulaActiVersion, expectedResult);
	sa.assertAll();
	
}
}
