package com.qualitypointtech.stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qualitypointtech.baseclasses.LaunchBrowser;
import com.qualitypointtech.baseclasses.ScreenShots;
import com.qualitypointtech.pages.EmployeeDetailsPage;
import com.qualitypointtech.pages.LoginPage;
import com.qualitypointtech.pages.LogoutPage;
import com.qualitypointtech.pages.NewUserPage;
import com.qualitypointtech.pages.OnlineTimeSheetPage;
import com.qualitypointtech.pages.RegisteredPage;
import com.qualitypointtech.utilities.ExcelRead;
import cucumber.api.java.en.*;

public class Steps  extends ExcelRead{
	WebDriver driver;
	ScreenShots screenShots;
	
	LoginPage loginPage;
	OnlineTimeSheetPage onlineTimeSheetPage ;
	NewUserPage newUserPage;
	RegisteredPage registeredPage;
	EmployeeDetailsPage employeeDetailsPage;
	LogoutPage logoutPage;
	
	@Given("^Launch Browser and Navigate to url$")
	public void launch_chrome_Browser_and_Navigate_to_url() throws Throwable {
		read();
		driver=LaunchBrowser.Launch_Browser("url");
		screenShots=new ScreenShots(driver);
	}

	
	@When("^Entering Username,Password and Click on Login button$")
	public void entering_Username_Password_and_Click_on_Login_button() throws Throwable {
		loginPage=new LoginPage(driver);
		loginPage.enterUserName();
	    loginPage.enterPassword();
	    screenShots.screenshot();
	    loginPage.clickOnLoginButton();
	}

	@Then("^Verification of Login Successfull message$")
	public void verification_of_Login_Successfull_message() throws Throwable {
		onlineTimeSheetPage =new OnlineTimeSheetPage (driver);
		onlineTimeSheetPage.verifyingLogin() ;
	}
	
	@Then("^Clicking on employee details and create new user$")
	public void clicking_on_employee_details_and_create_new_user() throws Throwable {
		onlineTimeSheetPage =new OnlineTimeSheetPage (driver);
		onlineTimeSheetPage.clickOnEmployeeDetails();
		screenShots.screenshot();
		onlineTimeSheetPage.clickOnCreateNewUser();
	}

	@Then("^Verification of new user page$")
	public void verification_of_new_user_page() throws Throwable {
		newUserPage =new NewUserPage(driver);
		newUserPage.verifyingNewUser();
	}
	@Then("^Entering Employee Details and Click on Save Details$")
	public void entering_Employee_Details_and_Click_on_Save_Details() throws Throwable {
		newUserPage =new NewUserPage(driver);
		newUserPage.employeeInformation();
		screenShots.screenshot();
		newUserPage.clickOnSaveDetails();
	}
	@Then("^Verification of Employee Details saved sucessfully message$")
	public void verification_of_Employee_Details_saved_sucessfully_message() throws Throwable {
		registeredPage =new RegisteredPage(driver);
		registeredPage.verifyingSuccessMessage();
		screenShots.screenshot();
	}

	@Then("^Clicking on Employee Details link$")
	public void clicking_on_Employee_Details_link() throws Throwable {
		registeredPage =new RegisteredPage(driver);
		registeredPage.clickOnEmployeeDetails();
	}
	@Then("^Verification of new user details is displayed in table or not$")
	public void verification_of_new_user_details_is_displayed_in_table_or_not() throws Throwable {
		employeeDetailsPage =new EmployeeDetailsPage(driver);
		employeeDetailsPage.verifyingNewUserDetails();
		screenShots.screenshot();
	}
	@Then("^Clicking on Logout$")
	public void clicking_on_Logout() throws Throwable {
		employeeDetailsPage =new EmployeeDetailsPage(driver);
		employeeDetailsPage.clickOnLogout();
	}
	@Then("^Verification of logout successfull message$")
	public void verification_of_logout_successfull_message() throws Throwable {

		logoutPage=new LogoutPage(driver);
		logoutPage.verifyingLogout();
	}
	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
	    driver.quit();
	}
}


	

