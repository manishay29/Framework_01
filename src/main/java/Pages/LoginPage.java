package Pages;

import java.time.Duration;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Runner.DataRunner;
import Utilities.Commonmethods;
public class LoginPage extends Commonmethods  {
  
	public DataRunner runner = new DataRunner();
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	WebElement ProfileButton;
	
	public LoginPage( WebDriver driver, int waitTime)  // parametrized construtor
	{
		PageFactory.initElements( driver, this);
		
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		
	}
	
	
	//method creation for login details
	public void fillLoginDetails() throws Exception {
	Properties readprop=
		readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
	


			
			
	//wait_obj.until(ExpectedConditions.visibilityOf(username));
//	waitForElementtobeVisible(username, 10);    
//	username.sendKeys(readprop.getProperty("UserName"));
	clearAndSendKeys(username, readprop.getProperty("UserName"), "username");
	//clearAndSendKeys(username,prop.get("UserName") , "username");
		
//		wait_obj.until(ExpectedConditions.visibilityOf(password));	
//		password.sendKeys(readprop.getProperty("Password"));
		
	clearAndSendKeys(password, readprop.getProperty("Password"), "password");
	
	//clearAndSendKeys(password, prop.get("Password"), "password");
	
		//wait_obj.until(ExpectedConditions.visibilityOf(login));
		
//		waitForElementtobeClickable(login, 5);
//		login.click();
	
	click(login, "login");
	waitForElementtobeVisible(ProfileButton, 11);
	Assert.assertTrue(ProfileButton.isDisplayed());
	
	}
	
	
}






