package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomePagePom extends BaseClass {
	
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement clickPIM;
	 
	// -----SEARCH EMPLOYEE WITH AVAILABLE INFORMATION -------//
	@FindBy(xpath="//div[contains(text(),'Virat')]")
	private WebElement firstName;
	
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")private WebElement employeeNm ;
	
	@FindBy(xpath="(//div[@role='listbox']//span)[1]")private WebElement employeeHint ;

	@FindBy(xpath="//div[text()='0249']")private WebElement getempId ;

	@FindBy(xpath="(//div//input[@class='oxd-input oxd-input--active'])[2]")private WebElement id ;

	@FindBy(xpath="(//button[@type='submit'])")private WebElement button_Save;

	
	//---------ADD EMPLOYEE----------------------//

	@FindBy(xpath="//li//a[text()='Add Employee']")private WebElement addEmp ;

	@FindBy(xpath="//input[@name='firstName']")private WebElement firstNm ;

	@FindBy(xpath="//input[@name='middleName']")private WebElement mddleNm;

	@FindBy(xpath="//input[@name='lastName']")private WebElement lastNm ;

	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")private WebElement e_Id ;

	@FindBy(xpath="//button[text()=' Save ']")private WebElement Click_save ;
	
	//-----------REPORTS------------------------//

	@FindBy(xpath="//li//a[text()='Reports']")private WebElement  Reports;

	@FindBy(xpath="//div[text()='PIM Sample Report']")private WebElement getReportNm;

	@FindBy(xpath="//input[@placeholder='Type for hints...']")private WebElement report_Nm ;
	 
	@FindBy(xpath="//div//div[@role='option']//span")private WebElement hint_name;
	
	@FindBy(xpath="//button[text()=' Search ']")private WebElement search;
	
	@FindBy(xpath="//button[@type='button']//i[@class='oxd-icon bi-file-text-fill']")
	private WebElement select_report_file ;
//	@FindBy(xpath="")private WebElement ;
//	@FindBy(xpath="")private WebElement ;
	
	
	// ---- ACTION METHOD OF -SEARCH EMPLOYEE WITH AVAILABLE INFORMATION -------//
	
	public void click_OnPim()
	{
		clickPIM.click();
	}
	
	
	public String getEmployeeNm()
	{
		return firstName.getText();
	}
	public void setEmployeeNm(String nm)
	{
		employeeNm.sendKeys(nm);
		
	}
	public void clickOnEmp()
	{
		employeeHint.click();
	}

	public String getEmpID()
	{
		return getempId.getText();
	}
	public void setEmpID(String Id)
	{
		id.sendKeys(Id);
	}
	public void clickOn_Save()
	{
		button_Save.click();
	}
	
	
	//-------ACTION METHODS OF--ADD EMPLOYEE----------------------//
	public void click_On_addEmp()
	{
		addEmp.click();
	}
	
	public void setEmployeefn(String eFNm)
	{
		firstNm.sendKeys(eFNm);
	}
	public void setEmployeeMN(String eMNm)
	{
		mddleNm.sendKeys(eMNm);
	}
	
	public void setEmployeeLN(String eLNm)
	{
		lastNm.sendKeys(eLNm);
	}
	public void setEmployeeID(String eID)
	{
		e_Id.sendKeys(eID);
	}
	public void clickOnSave() {
		Click_save.click();
	}
	
	//-ACTION METHOD-OF---------REPORTS------------------------//

	public void enterOnReport()
	{
		Reports.click();
		}
	public String getReportName()
	{
		return getReportNm.getText();
	}
	public void setReportName(String RName)
	{
		report_Nm.sendKeys(RName);
	}
	public void enterOnHint() {
		hint_name.click();
	}
	public void click_On_Search() {
		search.click();
	}
	public void clickON_Report()
	{
		select_report_file.click();
	}

}
