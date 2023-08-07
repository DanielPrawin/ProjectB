package com.obs.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.obs.common.StandardWaitTimes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions extends BasePage {

	
	
	public static void clickAction(WebDriver driver,ExtentTest test, 
			WebElement webElement,String fieldName) {
		boolean trueFalse=false;
		
		try {
			webElement.click();
			trueFalse=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (trueFalse)
			{
				test.log(Status.PASS, "'"+ fieldName +"'" + " is clicked successfully"+ "  ---> PASS");
			}
			else
			{
				test.log(Status.FAIL,  "'"+ fieldName +"'"  + " is Not clicked"+ "  ---> FAIL");
			}
		}
		
	}
	public static void typeAction(WebDriver driver, ExtentTest test, WebElement webElement,
		String fieldName, String testData) {
		boolean trueFalse=false;
		
		try {
			webElement.sendKeys(testData);
			trueFalse=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (trueFalse)
			{
				test.log(Status.PASS, "'"+ testData+"'" + " is entered in "+  fieldName + " successfully ---> PASS");
			}
			else
			{
				test.log(Status.FAIL,  "'"+ testData+"'"  + " is Not entered in "+  fieldName + "  ---> FAIL");
			}
		}
		
	}
	public static void verifyTestDataInAccountsWebTable(WebDriver driver, ExtentTest test, WebElement webElement,
			String name, String AccountNumber) {
			boolean trueFalse=false;
			String ActualValue = null;
			String ExceptedValue = AccountNumber.trim();
			try {
	            ActualValue = webElement.getText().trim();
	            if (ExceptedValue.equals(ActualValue))
				trueFalse=true;
	            else if(ExceptedValue.contains(ActualValue))
					trueFalse=true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if (trueFalse)
				{
					test.log(Status.PASS, "ExceptedValue is matched with ActualValue :: " + ExceptedValue + " = " + ActualValue + " ---> PASS");
									}
				else
				{
					test.log(Status.FAIL, "ExceptedValue is not matched with ActualValue" + ExceptedValue + " = " + ActualValue + "  ---> FAIL" );
				}
			}
			
		}
	public static void clearField(WebDriver driver,ExtentTest test, 
			WebElement webElement,String fieldName) {
		boolean trueFalse=false;
		
		try {
			webElement.clear();
			trueFalse=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (trueFalse)
			{
				test.log(Status.PASS, "'"+ fieldName+"'" + " is cleared successfully"+ "  ---> PASS");
			}
			else
			{
				test.log(Status.FAIL,  "'"+ fieldName+"'"  + " is Not cleared"+ "  ---> FAIL");
			}
		}
		
	}
	
	public static String getText(WebDriver driver,ExtentTest test, 
			WebElement webElement,String fieldName) {
		boolean trueFalse=false;
		String getValue =null;
		
		try {
			getValue = webElement.getText();
			trueFalse=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (trueFalse)
			{
				test.log(Status.PASS, "'"+ getValue+"'" + " Captured "+ "  ---> PASS");
			}
			else
			{
				test.log(Status.FAIL,  "'"+ fieldName+"'"  + " Captured "+ "  ---> FAIL");
			}
		}
		return getValue;
		
	}
}
