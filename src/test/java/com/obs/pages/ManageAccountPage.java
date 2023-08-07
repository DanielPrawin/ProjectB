package com.obs.pages;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obs.base.Actions;
import com.obs.common.StandardWaitTimes;

public class ManageAccountPage {

	Logger log = (Logger) LogManager.getLogger(ManageAccountPage.class);
	WebDriver driver;
	ExtentTest test;
  
    
	@FindBy(xpath="//p[normalize-space()='Account Management']")
	WebElement accountManagement;
    
	@FindBy(xpath="//p[normalize-space()='New Account']")
	WebElement newAccount;
	
	@FindBy(xpath = "//input[@name='account_number']")
	WebElement accountNumber;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='(optional)']")
	WebElement middleName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='generated_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='pin']")
	WebElement pin;
	
	@FindBy(xpath="//input[@name='balance']")
	WebElement balance;
	
	@FindBy(xpath="//button[@class='btn btn-primary mr-2']")
	WebElement save;
	
	@FindBy(xpath="//a[normalize-space()='Cancel']")
	WebElement cancel;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//tr[1]//td[2]")
	WebElement findAccountNumber_Verify;
	
	@FindBy(xpath="//tr[1]//td[3]")
	WebElement lastName_Verify;
	
	
	@FindBy(xpath="//button[contains(text(),'Action')]")
	WebElement actionButton;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editButton;
	
	
	
	
	public ManageAccountPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * //New Account Page
	 * 
	 * @SuppressWarnings("unlikely-arg-type") public void
	 * searchAccountNumberAndVerify(String AccountNumber) {
	 * Actions.typeAction(driver,test,search,"search",AccountNumber);
	 * Actions.verifyTestData(driver,test,findAccountNumber_Verify,"WebTable",
	 * AccountNumber);
	 * 
	 * }
	 */
		
		//New Account Page
		@SuppressWarnings("unlikely-arg-type")
		public void SearchWithAccountNumberAndEditTheLastName(String AccountNumber, String LastName) throws InterruptedException {
			/*
			 * (WebDriver driver, ExtentTest test, WebElement webElement, String name,
			 * String testData)
			 */
			Actions.typeAction(driver,test,search,"search",AccountNumber); 
			System.out.println("Edit Operation");
			Actions.clickAction(driver,test,actionButton,"actionButton"); 
			Actions.clickAction(driver,test,editButton,"editButton"); 
			Actions.clearField(driver,test,lastName,"LastName");
			Thread.sleep(3000);
			Actions.typeAction(driver,test,lastName,"LastName",LastName);
			Thread.sleep(3000);
			Actions.clickAction(driver,test,save,"save"); 		
		}
	
		//New Account Page
				@SuppressWarnings("unlikely-arg-type")
				public void SearchWithAccountNumberAndVerifyLastname(String AccountNumber,String LastName) {
				Actions.typeAction(driver,test,search,"search",AccountNumber); 
				Actions.verifyTestDataInAccountsWebTable(driver,test,lastName_Verify,"WebTable",LastName);
					
				}
}
