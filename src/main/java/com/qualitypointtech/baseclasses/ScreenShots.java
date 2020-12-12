package com.qualitypointtech.baseclasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	WebDriver driver;
	Logs log;
	static int count=0;
public ScreenShots(WebDriver driver) {
		this.driver=driver;
		log=new Logs(driver);
	}
//Takes the sreenshot  name
public void screenshot()
	{
	    File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File f2=new File("screenshots/screenshot["+count+"].png");
			
		try 
		{
			FileUtils.copyFile(f1,f2);
			System.out.println("screenshot is taken");
			log.update("ScreenShot is taken");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("error in taking screensot");
			log.update("Error in taking ScreenShots");
		}
		catch(IncompatibleClassChangeError e)
		{
			e.printStackTrace();
			log.update("Exception in incompatile class change error method");
		}
		count++;
		}
	}
