package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPom extends BaseClass {
	
	public LoginPom()
	{
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath = "//p[text() = 'Username : Admin']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement inputUsername;
	
	@FindBy(xpath = "//p[text() = 'Password : admin123']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement inputPassword;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-text oxd-text--p orangehrm-login-forgot-header')]")
	private WebElement forgotPassword;
	
	public String getUserName() {
		String uname = username.getText();
		
		return uname.substring(uname.indexOf('A'), uname.length());
	}
	
	public String getPassword() {
		String pass = password.getText();
		
		return pass.substring(pass.lastIndexOf('a'));
	}
	
	public HomePagePom loginButtonClick() {
		loginButton.click();
		return new HomePagePom();
	}

	

	public void setInputUsername(String setUsername) {
		inputUsername.sendKeys(setUsername);
	}

	

	public void setInputPassword(String setPassword) {
		inputPassword.sendKeys(setPassword.trim());
	}
	

}
