package com.qualitypointtech.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.qualitypointtech.baseclasses.DriverWait;
import com.qualitypointtech.baseclasses.Logs;
import com.qualitypointtech.utilities.ExcelRead;
import com.qualitypointtech.utilities.ExcelWrite;
import com.qualitypointtech.utilities.RandomStringGenerator;

public class NewUserPage {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	DriverWait driverWait;
	Logs log;
	RandomStringGenerator randomEmailGenerator;
	public String[][] test1=new String[1][1];
	
public NewUserPage(WebDriver driver)
	{
		this.driver=driver;
		driverWait=new DriverWait(driver);
		log=new Logs(driver);
	}
	By newUser=By.xpath("//td[text()='New Employee Registration Form']");
	
	By userName=By.id("employee_id");
	By firstName=By.xpath("//input[@name='first_name']");
	By password=By.xpath("(//input[@type='password'])[1]");
	By confirmPassword=By.xpath("(//input[@type='password'])[2]");
	By date=By.xpath("//input[@name='date']");
	By rate=By.xpath("//input[@name='rateperhour']");
	By email=By.xpath("//input[@name='emailid']");
	By country=By.id("country");
	By saveDetails=By.xpath("//input[@type='submit']");
	
//verifying new user page
public void verifyingNewUser() throws InterruptedException        
	{
		WebElement a=driverWait.visibility(newUser,20);         
		String actualData=a.getText();
			
		Assert.assertEquals(actualData,"New Employee Registration Form");
			
		System.out.println("New Employee Registration Form page is verified");
		log.update("******New Employee Registration Forme page is verified*****");
	}
//entering user name	
public void userName()        
	{
		randomEmailGenerator=new RandomStringGenerator();
		String userName1=randomEmailGenerator.userNameGeneration();
		ExcelWrite.write(2,userName1);
	
		WebElement a=driverWait.visibility(userName,20);         
		a.sendKeys(userName1);
		
		System.out.println("Username is entered");
		log.update("******Username is entered*****");
	}
//entering firstname
public void enterFirstName()        
	{
		test1=excel.read();
		String firstname=test1[0][3];
	
		WebElement a=driverWait.visibility(firstName,20);         
		a.sendKeys(firstname);
		
		System.out.println("Firstname is entered");
		log.update("******Firstname is entered******");
	}
//entering password	
public void enterPassword()        
	{
		test1=excel.read();
		String password1=test1[0][4];
	
		WebElement a=driverWait.visibility(password,20);         
		a.sendKeys(password1);
		
		System.out.println("Password is entered");
		log.update("******Password is entered*****");
	}
//entering confirm password	
public void enterConfirmPassword()        
	{
		test1=excel.read();
		String password1=test1[0][4];
	
		WebElement a=driverWait.visibility(confirmPassword,20);         
		a.sendKeys(password1);
		
		System.out.println("Confirm Password is entered");
		log.update("******Confirm Password is entered*****");
	}
//entering Date Of Joining
public void enterDateOfJoining()   
	{
		test1=excel.read();
		String date1=test1[0][5];
		String date2=date1.substring(1,11);
		
		WebElement a=driverWait.visibility(date,20);         
		a.sendKeys(date2);
	
		System.out.println("Date Of Joining is entered");
		log.update("******Date Of Joining is entered*****");
	}
//entering rate per hour
public void enterRate()        
	{
		test1=excel.read();
		String rate1=test1[0][6];
		String rate2=rate1.substring(1,4);
	
		WebElement a=driverWait.visibility(rate,20);         
		a.sendKeys(rate2);
	
		System.out.println("Rate per hour is entered");
		log.update("******Rate per hour is entered*****");
	}
//entering email
public void enterEmail()        
	{
		randomEmailGenerator=new RandomStringGenerator();
		String email1=randomEmailGenerator.emailGeneration();
		ExcelWrite.write(7,email1);
	 
		WebElement a=driverWait.visibility(email,20);         
		a.sendKeys(email1);
	
		System.out.println("email is entered");
		log.update("******email is entered*****");
	}
//entering country
public void enterCountry()        
	{
		test1=excel.read();
		String country1=test1[0][8];
	
		WebElement a=driverWait.clickable(country,20);
		Select dropdown=new Select(a);
		dropdown.selectByVisibleText(country1);
	
		System.out.println("Country is entered");
		log.update("******Country is entered*****");
	}
//click on save details button
public void clickOnSaveDetails()        
	{
		WebElement a=driverWait.clickable(saveDetails,20);     
		a.click();

		System.out.println("Save details button is clicked");
		log.update("******Save details button is clicked******");
	}
//all employee information
public void employeeInformation() 
	{
		this.userName();
		this.enterFirstName();
		this.enterPassword();
		this.enterConfirmPassword();
		this.enterDateOfJoining();
		this.enterRate();
		this.enterEmail();
		this.enterCountry();
	}
}
