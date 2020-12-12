package com.qualitypointtech.pages;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitypointtech.baseclasses.DriverWait;
import com.qualitypointtech.baseclasses.Logs;
import com.qualitypointtech.utilities.ExcelRead;
import com.qualitypointtech.utilities.RandomStringGenerator;

public class OnlineTimeSheetPage {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	DriverWait driverWait;
	Logs log;
	RandomStringGenerator randomEmailGenerator;
	public String[][] test1=new String[1][1];
	
	By logout=By.xpath("//a[@title='Edit your details']//following::span[1]//following::a[1]");
	By employeeDetails=By.xpath("//a[text()='Employee Details']");
	By createNewUser=By.xpath("//a[text()='Create New User']");
	
public OnlineTimeSheetPage(WebDriver driver) throws TimeoutException
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
		log=new Logs(driver);
	}
//Verifying succesfull login
public void verifyingLogin()        
	{
			WebElement a=driverWait.visibility(logout,20);         
			boolean button=a.isEnabled();
			
			if(button)
			{
				System.out.println("Login is successfull");
				log.update("******Login is successfull******");
			}
			else
			{
				System.out.println("Login is not successfull");
				log.update("******Login is not successfull******");
			}
	}
//clicking on employee details
public void clickOnEmployeeDetails()        
	{
		WebElement a=driverWait.clickable(employeeDetails,40);     
		a.click();
	
		System.out.println("Employee Details is clicked");
		log.update("******Employee Details is clicked******");
	}
//clicking on create new user
public void clickOnCreateNewUser()        
	{
		WebElement a=driverWait.clickable(createNewUser,40);     
		a.click();
	
		System.out.println("Create New User is clicked");
		log.update("******Create New User is clicked******");
	}
}
