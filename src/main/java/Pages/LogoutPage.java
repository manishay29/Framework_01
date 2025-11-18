package Pages;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.Commonmethods;

public class LogoutPage extends Commonmethods{
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][contains(.,'Dashboard')]")
	WebElement DashboardButton;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	WebElement ProfileButton;
	
	@FindBy(xpath="//a[contains(.,'Logout')]")
	WebElement logoutButton;
	
	//parametrized construtor
	public LogoutPage (WebDriver driver, int waitTime) {
		
		PageFactory.initElements(driver, this );
		wait_obj = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		
	}
		//method creation for login details
		public void logoff() throws Exception {
			
		click(DashboardButton, "Dashboard");
		
		click(ProfileButton, "profile");
		
		click(logoutButton, "Logout");
		
		
		
	}

}
