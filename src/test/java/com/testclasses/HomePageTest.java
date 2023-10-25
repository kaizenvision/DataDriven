package com.testclasses;

import java.io.IOException;

import com.listner.MyListner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.HomePagePom;
import com.pom.LoginPom;
@Listeners(MyListner.class)
public class HomePageTest extends BaseClass {
	
	@BeforeClass
	public void setup() throws IOException {
		lauchTheWeb();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void PimTest() {
		LoginPom loginPom = new LoginPom();
		loginPom.setInputUsername(loginPom.getUserName());
		loginPom.setInputPassword(loginPom.getPassword().trim());
		HomePagePom homePagePom = loginPom.loginButtonClick();
		homePagePom.click_OnPim();
		
		
	}

}
