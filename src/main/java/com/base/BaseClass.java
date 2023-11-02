package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utility.Utility;

public class BaseClass {
	
	public static WebDriver driver;
	
	FileInputStream fileInputStream;
	public static String projectPath = System.getProperty("user.dir");
	
	
	public void lauchTheWeb(String browser) throws IOException {
		
		fileInputStream = new FileInputStream(projectPath+"\\src\\main\\resources\\property\\config.properties");
		
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		Properties properties = new Properties();
		
		properties.load(fileInputStream);
		
		properties.getProperty("weburl");
		
		driver.get(properties.getProperty("weburl"));
		
		Utility.implictWeight();
	}
	
public void lauchTheWeb() throws IOException {
		
		fileInputStream = new FileInputStream(projectPath+"\\src\\main\\resources\\property\\config.properties");
		
		driver = new ChromeDriver();
			
		driver.manage().window().maximize();
		
		Properties properties = new Properties();
		
		properties.load(fileInputStream);
		
		properties.getProperty("weburl");
		
		driver.get(properties.getProperty("weburl"));
		
		Utility.implictWeight();
	}

}
