package Utilities;

import java.io.FileInputStream;
import java.lang.annotation.ElementType;
import java.time.Duration;
import java.util.Properties;

import javax.lang.model.element.Element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Pages.AdminUserPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.PimUser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonmethods {
	
	public static WebDriver driver;
	 public Properties prop;
	public WebDriverWait wait_obj;
	Actions actions ;
	public void launchBrowser() throws Exception
	{
		Properties prop = readConfig("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		
		 //read the browser name from config.properties file
		String  browsername= prop.getProperty("BrowserName");
		 
		 
		 if(browsername.equalsIgnoreCase("Chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 
		 }
		 else if(browsername.equalsIgnoreCase("firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 
		 }
		 else if(browsername.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 
		 }
		 else
		 {
			 System.out.println("Invalid browser name");
		 }
		 
		 //launching url by reading from config.properties
		 
		 String URL= prop.getProperty("URL");
		  driver.get(URL);
	}
	public Properties readConfig(String propertiespath) throws Exception {
		
	 FileInputStream fis= new FileInputStream("C:\\Users\\manis\\automation-New\\Framework_01\\src\\test\\java\\DataFiles\\config.properties");
		
	 prop = new Properties();
	 
	 prop.load(fis);
	 return prop;
			 
	}
	// method creation for wait till visibile
	public void waitForElementtobeVisible( WebElement element, int Waitime) 
	{
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(Waitime));
		wait_obj.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	// method creation for wait till clickable
	public void waitForElementtobeClickable( WebElement element, int Waitime) 
	{
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(Waitime));
		wait_obj.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	//individual method for action on webpage
	// method for clear and send keys
	public void clearAndSendKeys(WebElement element ,String value , String FeildName)
	{
		waitForElementtobeVisible(element, 5);
		highlight(element);
		element.clear();
		element.sendKeys(value);
		//System.out.println("entered" + value + " in " +FeildName );
		Reporter.log("entered" + value + " in " +FeildName );
		
	}
	
	//method for click action
	public void click (WebElement element ,String FeildName) 
	{
		waitForElementtobeClickable(element, 5);
		highlight(element);
		element.click();
		//System.out.println("clicked on "  +FeildName );
		Reporter.log("clicked on "  +FeildName );
	}
	
	//method for Select action on Dropdown
	
	public void selectFromDropdown(WebElement element , String Value, String choice , String FeildName )
	{
		
		waitForElementtobeClickable(element, 5);
		highlight(element);
	 Select select = new Select(element);
	 
	 switch (choice) 
	 {
	 	case "Index":
	 		int index=Integer.parseInt(Value);
	 		select.selectByIndex(index);
		break;
  
	 	case "Value":
	 		
	 		select.selectByValue(Value);	
	 	break;
		
	 	case "Visibletext":
	 		
	 		select.selectByVisibleText(Value);	
	 	break;
	 	
	 	
	 	default:
		   
	 		throw new  IllegalArgumentException( "unexpected value" + choice);
		
	}
	 
	// System.out.println("selected" + Value +  "from" + FeildName);
	 Reporter.log("selected" + Value +  "from" + FeildName);
		
	}
	
	//method for Action sendkeys
	
	public void sendkeysAction(WebElement element , String value , String Fieldname ) {
		
		actions = new Actions(driver);
		waitForElementtobeClickable(element, 2);
		actions.sendKeys(element,value).build().perform();
		Reporter.log("entered" + value + "in " +Fieldname);
	}
	//method for Action click
	public void clickAction (WebElement element , String Value , String Feildname) {
		
		actions = new Actions(driver);
		waitForElementtobeClickable(element, 2);
		actions.click().build().perform();
		Reporter.log("entered" + Value + "in " + Feildname);
	}
	
	//method for highlight fields 
	
	public void highlight(WebElement element) {
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public String getVisibletext(WebElement element , String Fieldname) {
		highlight(element);
     String value    =  element.getText();
    Reporter.log("fetched" + value + "from " + Fieldname);	 
		return value;
		
	}
	
	public String getAttributevalue(WebElement element ,String Attributename , String Fieldname) {
		highlight(element);
		String value    =  element.getAttribute(Attributename);
	    Reporter.log("fetched" + value + "of " + Attributename + "from " + Fieldname);	 
			return value;
			
		}
		
	
	
	
	
	public static void main(String args[]) throws Exception
	{
		Commonmethods b=new Commonmethods();
		b.launchBrowser();
		
		LoginPage childobject = new LoginPage(b.driver,10);
		childobject.fillLoginDetails();
		
		PimUser PimChild_obj = new PimUser(b.driver,10);
		PimChild_obj.fillPIMUserDetails();
		PimChild_obj.fillPersonalDetails();
	
		AdminUserPage  admin_obj = new AdminUserPage(b.driver, 10);
		admin_obj.fillAdminUserDetails();
		
		LogoutPage logout_obj = new LogoutPage (b.driver ,10);
		logout_obj.logoff();

		
		
	}
	
	
	
	
	

}
