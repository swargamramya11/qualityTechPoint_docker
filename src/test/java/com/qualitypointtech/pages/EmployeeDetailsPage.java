package com.qualitypointtech.pages;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qualitypointtech.baseclasses.DriverWait;
import com.qualitypointtech.baseclasses.Logs;
import com.qualitypointtech.utilities.ExcelRead;
import com.qualitypointtech.utilities.RandomStringGenerator;

public class EmployeeDetailsPage {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	DriverWait driverWait;
	Logs log;
	RandomStringGenerator randomEmailGenerator;
	public String[][] test1=new String[1][1];
	
	By table=By.xpath("//tr[@class='evenRow']");
	By logout=By.xpath("//a[@title='Edit your details']//following::span[1]//following::a[1]");
	
	
public EmployeeDetailsPage(WebDriver driver) throws TimeoutException
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
		log=new Logs(driver);
	}

//verifying new user is created in table or not
public void verifyingNewUserDetails() throws InterruptedException        
	{
	test1=excel.read();
	String expectedUserName=test1[0][2];
	
	List<WebElement> allUserNames = driver.findElements(By.xpath("//tr[@class='evenRow']"));
	for(WebElement userName:allUserNames)
	{
		String actualUserName=userName.getText();
		if(actualUserName.equals(expectedUserName))
		{
			System.out.println("New user details exist in table");
			log.update("******New user details exist in table*****");
			break;
		}
	}
	}
//clicking on logout
public void clickOnLogout()        
	{
		WebElement a=driverWait.clickable(logout,40);     
		a.click();
	
		System.out.println("Logout is clicked");
		log.update("******Logout is clicked******");
	}
}
