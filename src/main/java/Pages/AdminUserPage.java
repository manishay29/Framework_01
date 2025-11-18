package Pages;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicIntegerArray;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

import Utilities.Commonmethods;

public class AdminUserPage extends Commonmethods {

	@FindBy (xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][contains(.,'Admin')]")
	WebElement Admin;
	

	@FindBy (xpath = "//button[@type='button'][contains(.,'Add')]")
	WebElement AddUser;
	
	@FindBy (xpath= "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement UserRole;
	
	@FindBy (xpath ="//div[@role='option'][contains(.,'Admin')]")
	WebElement UserRoleadmin ;
	
	@FindBy (xpath="//input[contains(@placeholder,'Type for hints...')]")
	WebElement EmployeeName;
	
	@FindBy (xpath="//div[@role='option'][contains(.,'Peter')]")
	WebElement chooseEmployeeName;
	
	@FindBy (xpath = "//div[@class='oxd-select-text-input'][contains(.,'-- Select --')]")
	WebElement Status;
	
	@FindBy (xpath ="//div[@role='option'][contains(.,'Enabled')]")
	WebElement statusoption;
	
	@FindBy (xpath ="(//input[contains(@class,'oxd-input oxd-input--active')])[2]")
	WebElement Username;
	
	@FindBy(xpath = "(//input[contains(@type,'password')])[1]")
	WebElement pass;
	
	@FindBy (xpath="(//input[@type='password'])[2]")
	WebElement confpass;
	
	@FindBy (xpath="//button[contains(@type,'submit')]")
	WebElement Save;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Search;
	
	@FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span[1]")
	WebElement SearchCount;

	public AdminUserPage (  WebDriver driver, int waitTime) {
		
		PageFactory.initElements(driver, this);
		
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		
		
	}
	
	//method for add admin user
	
	public void fillAdminUserDetails () throws Exception {
		
		Properties prop= readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		
		click(Admin, "Admin");
		
		click(AddUser, "add user");
		
		click(UserRole, "user role ");
		
		//click(UserRoleadmin, "UserRoleadmin");
		//dynamic xpath 
	WebElement useroleoption= 	driver.findElement(By.xpath("//div[@role='option'][contains(.,'"+prop.getProperty("Userrole") +"')]"));
		click(useroleoption, prop.getProperty("Userrole"));
		
		
		
		clearAndSendKeys(EmployeeName, prop.getProperty("EmployeeName"), "EmployeeName");
		
		
		
		click(chooseEmployeeName, "chooseEmployeeName");
		
		
		click(Status, "status");
		
		click(statusoption, "Enabled");
		
		clearAndSendKeys(Username, prop.getProperty("Username"), "user name ");
		
		clearAndSendKeys(pass, prop.getProperty("password1"), "password");
		
		clearAndSendKeys(confpass, prop.getProperty("ConfirmPassword"), "ConfirmPassword");
		
		click(Save, "save");
		
	}
	
	
	public void searchAdminUser () throws Exception {
		
		waitForElementtobeClickable(AddUser, 5);
		
		click(Admin, "Admin");
		
		click(Username, " username");
		clearAndSendKeys(Username, prop.getProperty("Username"), "Username");
		
		click(UserRole, " user role");
		waitForElementtobeVisible(UserRoleadmin, 2);
		click(UserRoleadmin, "UserRoleadmin");
	
		clearAndSendKeys(EmployeeName, prop.getProperty("EmployeeName"), "EmployeeName");
		waitForElementtobeVisible(chooseEmployeeName, 5);
		click(chooseEmployeeName, "chooseEmployeeName");
		
		click(Status, "status");
		//click(statusoption, "Enabled");
		//dyanamic xpath 
		WebElement statusoption= driver.findElement(By.xpath("//div[@role='option'][contains(.,'"+prop.getProperty("statusoption")+"')]"));
		click(statusoption, prop.getProperty("statusoption"));
		
		
		click(Search, "search");

		String SearchRecordText = getVisibletext(SearchCount, "search record found ");
		String Totalrecord =	SearchRecordText.split("\\)")[0].trim().replace("(", "").replace("(", "");
		try 
		{
			int totalrecordcount = Integer.parseInt(Totalrecord);
			Assert.assertEquals(totalrecordcount, 1);
			Reporter.log("verification successful for toatal record ");
		}
		
		catch (Exception e) 
		{
			Assert.assertEquals(Totalrecord, "1");
			
			Reporter.log("verification successful for toatal record ");


		}
		
		
	}
	
}
