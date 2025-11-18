package Runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import StepDefinition.OrangeHRMSteps;
import Utilities.Commonmethods;

public class StepRunner {
	OrangeHRMSteps OS = new OrangeHRMSteps();
	Commonmethods CM = new Commonmethods();
	
	@BeforeMethod
	public void launchBrowser() throws Exception {
		
		
		CM.launchBrowser();
	}
	
	@Test
	public void loginTest() throws Exception {
		
		
		OS.loginSteps();
	}
	
	@Test
	public void addPimUser() throws Exception {
		
		
		OS.loginSteps();
		OS.pimUserSteps();
		OS.logoutStep(); 
	}
	
	@Test
	public void adduser() throws Exception {
		
		OS.loginSteps();
		OS.adduserSteps();
		OS.logoutStep(); 
	}
	
	
	@Test
	public void  logout() throws Exception {
		
		OS.loginSteps();
		OS.logoutStep(); 
		
		
		
	}
	
	@AfterMethod
	public void closeDriver() {
		
		CM.driver.quit();
		
	}
}
