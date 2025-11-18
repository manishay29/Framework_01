package Pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Commonmethods;

public class PimUser extends Commonmethods {

	// for click on pim button from dashboard 
	@FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")
	WebElement PIM_button;
	
	// for click on add button 
	@FindBy(xpath="//button[@type='button'][contains(.,'Add')]")
	WebElement ADD_button;
	
	// XPATH FOR    "Add Employee"     SECTION
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
	WebElement First_Name;

	@FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
	WebElement Middle_Name;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement Last_Name;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	
	//      XPATH FOR  "Personal Details tab"  SECTION
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleName;
		
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement Licensenumber ;
	
	
	@FindBy(xpath ="//input[@placeholder='yyyy-dd-mm']")
	WebElement LicenseExpiryDate;
	
	//@FindBy(xpath = "//div[@class='oxd-calendar-date'][contains(.,'30')]")
	
	//@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
	@FindBy(xpath = "(//div[@clear='false'][contains(.,'-- Select --')])[1]")
	WebElement Nationality;   //@FindBy(xpath = "//div[@clear='false'][contains(.,'Indian')]")
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
	WebElement MaritalStatus;  //@FindBy(xpath = "//div[@role='option'][contains(.,'Single')]")
	 
	
	@FindBy(xpath = "//label[contains(.,'Female')]")
	WebElement FemaleRadio;
	
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
	WebElement Test_Field;
	
	@FindBy(xpath = "//button[contains(.,'Add')]")
	WebElement addAttachment;
	
	@FindBy(xpath = "//textarea[@placeholder='Type comment here']")
	WebElement comment;
	
	@FindBy(xpath = "(//button[@type='submit'])[3]")
	WebElement Save;
	
	
	//  XPATH FOR  "Contact Details tab"  SECTION
	
	
	
	
	
	
	public PimUser( WebDriver driver, int waitTime)  // parametrized construtor for child class
	{
		PageFactory.initElements( driver, this);
		
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		
	}
	
	//method creation for PIM user creation
		public void fillPIMUserDetails() throws Exception {
		Properties readprop=
			readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		
		
			//wait_obj.until(ExpectedConditions.visibilityOf(PIM_button));
			
//		waitForElementtobeVisible(PIM_button, 2);
//		PIM_button.click();
		click(PIM_button, "PIM_button");	
		
//		wait_obj.until(ExpectedConditions.visibilityOf(ADD_button));
//		waitForElementtobeClickable(ADD_button, 3);	
//		ADD_button.click();
		click(ADD_button, "ADD_button");
		
			
//			wait_obj.until(ExpectedConditions.visibilityOf(First_Name));
//			First_Name.sendKeys(readprop.getProperty("PIMFirstName"));
		clearAndSendKeys(First_Name, readprop.getProperty("PIMFirstName"), "First_Name");
		
//			wait_obj.until(ExpectedConditions.visibilityOf(Middle_Name));	
//			Middle_Name.sendKeys(readprop.getProperty("PIMMiddleName"));
		clearAndSendKeys(Middle_Name, readprop.getProperty("PIMMiddleName"), "Middle_Name");
		
		
//			wait_obj.until(ExpectedConditions.visibilityOf(Last_Name));	
//			Last_Name.sendKeys(readprop.getProperty("PIMLastName"));
		clearAndSendKeys(Last_Name , readprop.getProperty("PIMLastName"), "Last_Name");
		
//			wait_obj.until(ExpectedConditions.visibilityOf(Submit));
//			Submit.click();
		click(Submit, "Submit");
	
}
		public void  fillPersonalDetails() throws Exception {
		
		Properties readprop=
					readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		waitForElementtobeVisible(Licensenumber,5);	
			clearAndSendKeys(Licensenumber, readprop.getProperty("DriverLicenseNumber"), "Licensenumber ");
		waitForElementtobeClickable(LicenseExpiryDate, 5);
			
			click(LicenseExpiryDate, "LicenseExpiryDate");
			    WebElement date = driver.findElement(By.xpath("//div[@class='oxd-calendar-date' and contains(.,'30')]"));
	    click(date, "Date");
	    System.out.println("date choosed"); 
	    
	    
			waitForElementtobeClickable(Nationality, 5);
		click(Nationality, "Nationality ");
			Select choosenatinality = new Select(Nationality);
		waitForElementtobeClickable(Nationality, 5);
			choosenatinality.selectByValue( (prop.getProperty("Nationality")));  
			
		
			
			//clearAndSendKeys(Nationality, readprop.getProperty("Nationality"), "Nationality");
		WebElement choosenationality = driver.findElement(By.xpath("//div[@clear='false'][contains(.,'"+prop.getProperty("Nationality")+"')]"));
			waitForElementtobeClickable(choosenationality, 5);
			click(choosenationality, prop.getProperty("Nationality"));
		
			
		}
		
	
		public void fillPersonalDetails2() throws Exception {
		    Properties readprop = readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		    waitForElementtobeVisible(Licensenumber, 5);
		    clearAndSendKeys(Licensenumber, readprop.getProperty("DriverLicenseNumber"), "Licensenumber ");
		    System.out.println("number given");
		    
		    waitForElementtobeClickable(LicenseExpiryDate, 5);
		    click(LicenseExpiryDate, "LicenseExpiryDate");

		    // Select the date from the calendar widget
		    WebElement date = driver.findElement(By.xpath("//div[@class='oxd-calendar-date' and contains(.,'30')]"));
		    click(date, "Date");
		    System.out.println("date choosed");

		    waitForElementtobeClickable(Nationality, 5);
		    click(Nationality, "Nationality ");
		    Select choosenatinality = new Select(Nationality);
		    waitForElementtobeClickable(Nationality, 5);
		    choosenatinality.selectByValue((prop.getProperty("Nationality")));
		    
		    //clearAndSendKeys(Nationality, readprop.getProperty("Nationality"), "Nationality");
		    WebElement choosenationality = driver.findElement(By.xpath("//div[@clear='false'][contains(.,'" + prop.getProperty("Nationality") + "')]"));
		    waitForElementtobeClickable(choosenationality, 5);
		    click(choosenationality, prop.getProperty("Nationality"));
		    System.out.println("natinality choosed");
		}
		
		
		
		
		
		
		
}

