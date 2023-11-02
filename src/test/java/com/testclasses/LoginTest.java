package com.testclasses;

import java.io.IOException;
import java.util.Map;

import com.listner.MyListner;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.BaseClass;
import com.myexceptin.UserNotFoundException;
import com.pom.LoginPom;
import com.utility.Utility;

@Listeners(MyListner.class)
public class LoginTest extends BaseClass {
	
	
	ExtentSparkReporter extentSparkReporter ;
	ExtentReports extentReports ;
	ExtentTest logger;
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) {
		try {
			lauchTheWeb(browser);
			extentSparkReporter = new ExtentSparkReporter(projectPath+"//extentReport//testReport.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void attachScreenShot(ITestResult result) {
		Utility.implictWeight();
		logger.addScreenCaptureFromPath(projectPath+"/screenshots/"+result.getName(), result.getTestName());
		
	}
	
	@AfterClass
	public void tearDown() {
		Utility.implictWeight();
		extentReports.flush();
		driver.quit();
	}

	@Test(dataProvider = "logindata", groups = {"sanity"})
	public void loginTest(Map<String, String> data) throws InterruptedException {
		logger = extentReports.createTest("loginTest");
		LoginPom loginPom = new LoginPom();
		loginPom.setInputUsername(data.get("username"));
		loginPom.setInputPassword(data.get("password"));
		logger.log(Status.INFO, "running test with username "+ data.get("username"));
		logger.log(Status.INFO, "running test with password "+ data.get("password"));
		loginPom.loginButtonClick();
		Thread.sleep(5000);
		String actual = driver.getCurrentUrl();
		String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		/*
		 * try { throw new UserNotFoundException(); }catch(Exception e)
		 * {e.printStackTrace();}
		 */
		//Assert.assertEquals(actual, expected);
		
	}
	
	//forgotpass
	
	// getTitle
	
	//grtcurrentUrl
	
	//logo
	
	//differentusers
	

	public void testUsers() throws EncryptedDocumentException, IOException, InterruptedException {
		
		LoginPom loginPom = new LoginPom();
		
		Utility utility = new Utility();
		
		Sheet sh = utility.getSheet("Sheet1");
		
		getDataFromExcel();
		
		String key = (String) utility.getSingleData(1, 0, sh);
		String value = (String) utility.getSingleData(1, 1, sh);
		
		//Assert.assertEquals(key, null, "kay value must not be null...");
		
		SoftAssert assert1 = new SoftAssert();
		
		assert1.assertEquals(key, null, "kay value must not be null...");
		
	//	loginPom.setInputUsername();
	//	loginPom.setInputPassword();
		
		Utility.implictWeight();
		
		loginPom.loginButtonClick();
		
		Thread.sleep(5000);
		
		
		assert1.assertAll();
	}
	
	@DataProvider(name="logindata")
	public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException {
		Utility utility = new Utility();
		
		Sheet sh = utility.getSheet("Sheet1");
		
		Object[][] data = utility.getData(sh);
		
		return data;
	}
	
}
