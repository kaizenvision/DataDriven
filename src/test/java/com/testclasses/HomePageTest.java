package com.testclasses;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pom.HomePagePom;
import com.pom.LoginPom;

public class HomePageTest extends BaseClass {
	
	@BeforeClass
	public void setup() throws IOException {
		lauchTheWeb();
	}
	
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
