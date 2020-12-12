package com.qualitypointtech.pages;

import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitypointtech.baseclasses.DriverWait;
import com.qualitypointtech.baseclasses.Logs;
import com.qualitypointtech.utilities.ExcelRead;
import com.qualitypointtech.utilities.RandomStringGenerator;

public class LogoutPage {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	DriverWait driverWait;
	Logs log;
	
	By logoutMessage=By.id("logoutstatus");
	public LogoutPage(WebDriver driver) throws TimeoutException
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
		log=new Logs(driver);
	}
	
//verifying logout page
public void verifyingLogout()        
	{
			WebElement a=driverWait.visibility(logoutMessage,20);         
			String actualMessage=a.getText();
			
			Assert.assertTrue(actualMessage.contains("You have been logged out."));
			
			System.out.println("Logout message is verified");
			log.update("******Logout message is verified*****");
	}
}
