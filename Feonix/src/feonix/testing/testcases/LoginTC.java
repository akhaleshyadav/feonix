package feonix.testing.testcases;

import org.testng.annotations.Test;

import feonix.testing.base.Base;
import feonix.testing.pom.Login;
import feonix.testing.utilities.Screenshots;
import feonix.testing.utilities.Logs;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;





public class LoginTC extends Base {
	@Test(dataProvider = "LoginData")
	public void LoginTest(String Userid, String Password) throws InterruptedException, IOException
	{   
		try {
		System.out.println(Userid);
		System.out.println(Password);
		
		WebElement lgb=driver.findElement(By.id("lnkLogin"));
		lgb.click();
		Thread.sleep(2000);
		Logs.Takelog("LoginTC", "Login button clicked successfully");
		//For valid case
		Login l =new Login(driver, pr);
		
		
		l.Signin(Userid, Password );    //Case-1 Invalid id and Pwd
		Thread.sleep(3000);
		WebElement loginErr=driver.findElement(By.id("divLoginErrMsg"));
		boolean er1=loginErr.isDisplayed();
		System.out.println(er1);
		WebElement HmMenu=driver.findElement(By.id("lnlLabel"));
		boolean Menu1=HmMenu.isDisplayed();
		System.out.println("Menu"+ " "+ Menu1);
		if (er1=true) 
		{
		  System.out.println("Login test - Pass for Invalid credential, it prompts validation for invalid credentials"+Userid+" "+Password);
		  Logs.Takelog("LoginTC", "Login test -Pass for Invalid credential, it prompts validation for invalid credentials"+Userid+" "+Password);
		  Screenshots.TakesScreenshots(driver, "D:\\SeleniumProjects\\feonix\\screenshots\\Msg_InvalidCredentials.jpeg");
		}
		 else if (Menu1=true)
				{
			    System.out.println("Login test - Pass for valid credential, it redirects to home screen"+Userid+" "+Password);
				Logs.Takelog("LoginTC", "Login test - Pass for valid credential, it redirects to home screen"+Userid+" "+Password);
				Screenshots.TakesScreenshots(driver, "D:\\SeleniumProjects\\feonix\\screenshots\\LoggedWithValidCredentials.jpeg");
				}
			    else {
		      System.out.println("Login test - Fail for valid credential, it does not redirect to home screen for valid credentials"+Userid+" "+Password);
		      Logs.Takelog("LoginTC", "Login test -Fail for valid credential, it does not redirect to home screen for valid credentials"+Userid+" "+Password);
		       Screenshots.TakesScreenshots(driver, "D:\\SeleniumProjects\\feonix\\screenshots\\LoginFailedForValidCredentials.jpeg");
			    }
	}
	catch(Exception e) {
		Logs.Takelog("LoginTC", e.getMessage());
		Screenshots.TakesScreenshots(driver, "D:\\SeleniumProjects\\feonix\\screenshots\\LoginException.jpeg");

	}	
	}}

