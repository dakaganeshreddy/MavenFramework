package generic;

import org.testng.annotations.Test;

import pompages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;
	static{
		System.setProperty(GECKO_KEY, GECKO_PATH);
		System.setProperty(CHROME_KEY, CHROME_PATH);
		//System.setProperty(IE_KEY, IE_PATH);
	}
	@Parameters("browser")
	@BeforeMethod
	public void openApplication(String browser){
		if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		String url = Lib.getPropertyValue("URL");
		driver.get(url);
		String ito = Lib.getPropertyValue("IMPLICIT.WAIT");
		long implicitWait = Long.parseLong(ito);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
	}
	@AfterMethod
public void closeApplication(ITestResult res){
		
		if (ITestResult.FAILURE== res.getStatus()) {
			Lib.captureScreenshot(driver, res.getName());
			
			
		}
		
		driver.close();
	}
}
