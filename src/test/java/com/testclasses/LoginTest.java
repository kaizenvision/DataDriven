package com.testclasses;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.myexceptin.UserNotFoundException;
import com.pom.LoginPom;
import com.utility.Utility;

public class LoginTest extends BaseClass {
	
	
	
	@BeforeMethod
	public void setUp() {
		try {
			lauchTheWeb();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		Utility.implictWeight();
		driver.quit();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		LoginPom loginPom = new LoginPom();
		loginPom.setInputUsername(loginPom.getUserName());
		loginPom.setInputPassword(loginPom.getPassword());
		loginPom.loginButtonClick();
		Thread.sleep(5000);
		String actual = driver.getCurrentUrl();
		String expected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		/*
		 * try { throw new UserNotFoundException(); }catch(Exception e)
		 * {e.printStackTrace();}
		 */
		Assert.assertEquals(actual, expected);
		
	}
	
	//forgotpass
	
	// getTitle
	
	//grtcurrentUrl
	
	//logo
	
	//differentusers
	
	@Test(dataProvider = "logindata")
	public void testUsers(Map<String, String> data) throws EncryptedDocumentException, IOException, InterruptedException {
		
		LoginPom loginPom = new LoginPom();
		
		Utility utility = new Utility();
		
		Sheet sh = utility.getSheet("Sheet1");
		
		getDataFromExcel();
		
		String key = (String) utility.getSingleData(1, 0, sh);
		String value = (String) utility.getSingleData(1, 1, sh);
		
		//Assert.assertEquals(key, null, "kay value must not be null...");
		
		SoftAssert assert1 = new SoftAssert();
		
		assert1.assertEquals(key, null, "kay value must not be null...");
		
		loginPom.setInputUsername(data.get(key));
		loginPom.setInputPassword(data.get(value));
		
		Utility.implictWeight();
		
		loginPom.loginButtonClick();
		
		Thread.sleep(5000);
		
		
		assert1.assertAll();
	}
	
	@DataProvider(name="logindata")
	public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException {
		Utility utility = new Utility();
		
		Sheet sh = utility.getSheet("Sheet1");
		
		Object[][] data = utility.getAllExcelData(sh);
		
		return data;
	}
	
}
