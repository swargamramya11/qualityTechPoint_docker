package com.qualitypointtech.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitypointtech.baseclasses.DriverWait;
import com.qualitypointtech.baseclasses.Logs;
import com.qualitypointtech.utilities.ExcelRead;

public class RegisteredPage {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	DriverWait driverWait;
	Logs log;
	
public RegisteredPage(WebDriver driver)
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
		log=new Logs(driver);
	}
	By successMessage=By.xpath("//form[@name='frmNewUserCreation']//following::font[1]");
	By employeeDetails=By.xpath("//a[@title=' Edit Employee']");
	
//verifying Employee Details saved sucessfully message
public void verifyingSuccessMessage() throws InterruptedException        
	{
		WebElement a=driverWait.visibility(successMessage,20);         
		String actualData=a.getText();
			
		Assert.assertEquals(actualData,"Employee Details saved sucessfully");
			
		System.out.println("Employee Details saved sucessfully is verified");
		log.update("******Employee Details saved sucessfully is verified*****");
	}
//click on employee Details link
public void clickOnEmployeeDetails()        
	{
		WebElement a=driverWait.clickable(employeeDetails,20);     
		a.click();

		System.out.println("Employee Details is clicked");
		log.update("******Employee Details is clicked******");
	}
}
