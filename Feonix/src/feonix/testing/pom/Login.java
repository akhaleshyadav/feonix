package feonix.testing.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import feonix.testing.base.Base;

public class Login extends Base {
	
	
	
    public Login(ChromeDriver driver, Properties pr)
		   {
			   this.driver=driver;
			   this.pr=pr;
		   }
	public void Signin(String uid, String Pwd) throws InterruptedException
    {   
    	Thread.sleep(5000);
    	WebElement userid = driver.findElement(By.id("txtLoginUserId"));
		userid.sendKeys(uid);
		Thread.sleep(2000);
		WebElement Password = driver.findElement(By.id("txtpassword"));
		Password.sendKeys(Pwd);
		Thread.sleep(2000);
		WebElement LetsGo_login=driver.findElement(By.id("btnloginCmd"));
		LetsGo_login.click();
		Thread.sleep(5000);
    }
}
