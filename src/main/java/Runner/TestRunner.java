package Runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PimUser;
import Utilities.Commonmethods;

public class TestRunner  {
	// global declaration 
	Commonmethods CM;
	@BeforeMethod
	public void launch() throws Exception {
		
		CM = new Commonmethods();
		CM.launchBrowser();
	}
	
	@Test
	public void loginFunctionlityTest () throws Exception {
		
	
		LoginPage LP = new LoginPage(CM.driver, 2);
		LP.fillLoginDetails();
		
	}
	
 @Test
 public void addPIMuser() throws Exception {
	 LoginPage LP = new LoginPage(CM.driver, 2);
	 LP.fillLoginDetails();
	 
	 PimUser PU = new PimUser(CM.driver, 3);
	 PU.fillPIMUserDetails();
	 
	 
 }
	
	
@AfterMethod
public void closeSession() {
	
	//CM.driver.close();
	CM.driver.quit();
	
	
}
	
}



