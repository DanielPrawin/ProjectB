package com.obs.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.obs.base.BasePage;
import com.obs.listeners.ListenerClass;
import com.obs.pages.AdminHomePage;
import com.obs.pages.AdminLoginPage;
import com.obs.pages.NewAccountPage;
import com.obs.utilities.RandomNumber;
import com.obs.utilities.ReadProperties;



public class CreateNewUserAccount_1 extends BasePage{
	Logger log = (Logger) LogManager.getLogger(AdminLoginPage.class);
	String url,userName,Password;
	long accountNumber = RandomNumber.getRandomNumber();
	String emailId = "onlinetestinghelp"+accountNumber+"@gmail.com";
	String userPwd = "123456";
	String deposit_Amount = "10000";
	int expected_Balance = 1010000;
	
	@Test
	public void CreateNewUserAccount_1() throws IOException, InterruptedException {

		//Verify admin login
		String url,userName,Password;
		
		url = ReadProperties.readProp("AdminURL");
		userName = ReadProperties.readProp("AdminUN");
		Password = ReadProperties.readProp("AdminPwd");
		//Object Creation For Required Pages
		AdminLoginPage login = new AdminLoginPage(driver,test);
		AdminHomePage adminHomePage = new AdminHomePage(driver,test);
		NewAccountPage newAccountPage = new NewAccountPage(driver,test);		
		
		// Login Into WebApplication
		login.launchApp(url);
		login.login(userName, Password);		

		adminHomePage.verifyHomePageText();		
				
		String AccountNumber = String.valueOf(accountNumber);
		String AccountFirstNameNumber = "Daniel";
		String middleName = "Prawin";
		String lastName = "Kumar";
		String email = emailId;
		String password = userPwd ;
		String pin = "1234";
		String balance =  "100000";
		
		log.info("Create New Account");		
		newAccountPage.NewUserCreation(AccountNumber,AccountFirstNameNumber,middleName,lastName,email,password,pin,balance);
		newAccountPage.searchAccountNumberAndVerify(AccountNumber);
		//adminHomePage.logout();
		
	}
	
}
