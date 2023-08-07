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

public class DashBoardPage {

	Logger log = (Logger) LogManager.getLogger(DashBoardPage.class);
	WebDriver driver;
	ExtentTest test;
  
    
	
	
	@FindBy(xpath="//p[contains(text(),'Dashboard')]")
	WebElement dashBoard;
	
	@FindBy(xpath="//span[contains(text(),'Total Accounts Balance')]//following-sibling::*[@class='info-box-number']")
	WebElement totalAccountBalance;
	
	@FindBy(xpath="//span[contains(text(),'Total Accounts')]/following-sibling::*[@class='info-box-box']")
	WebElement totalAccountsCountValue;
	
	
	public DashBoardPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		driver.manage().timeouts().implicitlyWait(StandardWaitTimes.waitTime, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	

		@SuppressWarnings("unlikely-arg-type")
		public String getTotalAccountBalance() {
		Actions.clickAction(driver,test,dashBoard,"DashBoard");
		return Actions.getText(driver, test, totalAccountBalance,"TotalAccountBalance");
		}

		@SuppressWarnings("unlikely-arg-type")
		public String getTotalAccountsCount() {
		Actions.clickAction(driver,test,dashBoard,"DashBoard");
		return Actions.getText(driver, test, totalAccountsCountValue,"TotalAccountsCount");
		}

		public void verifyTotalAccountBalance(String getTotalAccountBalanceBeforeCreatingNewUser,
				String getTotalAccountBalanceAfterCreatingNewUser,String AddValue) {
			getTotalAccountBalanceBeforeCreatingNewUser =getTotalAccountBalanceBeforeCreatingNewUser.replace(",", "").trim();
			getTotalAccountBalanceAfterCreatingNewUser =getTotalAccountBalanceAfterCreatingNewUser.replace(",", "").trim();
			int int_AddValue = Integer.parseInt(AddValue.replace(",", "").trim());
			
			int int_getTotalAccountBalanceBeforeCreatingNewUser = Integer.parseInt(getTotalAccountBalanceBeforeCreatingNewUser);
			int int_getTotalAccountBalanceAfterCreatingNewUser =  Integer.parseInt(getTotalAccountBalanceAfterCreatingNewUser);
			
			int_getTotalAccountBalanceBeforeCreatingNewUser =int_getTotalAccountBalanceBeforeCreatingNewUser + int_AddValue;
			if (int_getTotalAccountBalanceBeforeCreatingNewUser == int_getTotalAccountBalanceAfterCreatingNewUser)
			{
				test.log(Status.PASS, "ExceptedValue is matched with ActualValue :: " + int_getTotalAccountBalanceBeforeCreatingNewUser + " = " + int_getTotalAccountBalanceAfterCreatingNewUser + " ---> PASS");
			}
			else
			{
				test.log(Status.FAIL,  "ExceptedValue is matched with ActualValue :: " + int_getTotalAccountBalanceBeforeCreatingNewUser + " = " + int_getTotalAccountBalanceAfterCreatingNewUser + "---> FAIL");
			}
		}
		
		public void verifyTotalAccountsCountValue(String getTotalAccountValueBeforeCreatingNewUser,
				String getTotalAccountValueAfterCreatingNewUser) {
			getTotalAccountValueBeforeCreatingNewUser =getTotalAccountValueBeforeCreatingNewUser.replace(",", "").trim();
			getTotalAccountValueAfterCreatingNewUser =getTotalAccountValueAfterCreatingNewUser.replace(",", "").trim();
			
			
			int int_getTotalAccountBalanceBeforeCreatingNewUser = Integer.parseInt(getTotalAccountValueBeforeCreatingNewUser)+1;
			int int_getTotalAccountBalanceAfterCreatingNewUser =  Integer.parseInt(getTotalAccountValueAfterCreatingNewUser);
			
			
			if (int_getTotalAccountBalanceBeforeCreatingNewUser == int_getTotalAccountBalanceAfterCreatingNewUser)
			{
				test.log(Status.PASS, "ExceptedValue is matched with ActualValue :: " + int_getTotalAccountBalanceBeforeCreatingNewUser + " = " + int_getTotalAccountBalanceAfterCreatingNewUser + " ---> PASS");
			}
			else
			{
				test.log(Status.FAIL,  "ExceptedValue is matched with ActualValue :: " + int_getTotalAccountBalanceBeforeCreatingNewUser + " = " + int_getTotalAccountBalanceAfterCreatingNewUser + "---> FAIL");
			}
		}
	
}
