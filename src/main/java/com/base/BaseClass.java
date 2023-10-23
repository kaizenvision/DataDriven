package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Utility;

public class BaseClass {
	
	public static WebDriver driver;
	
	FileInputStream fileInputStream;
	public static String projectPath = System.getProperty("user.dir");
	
	
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
