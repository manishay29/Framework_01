package StepDefinition;

import Pages.AdminUserPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.PimUser;
import Utilities.Commonmethods;

public class OrangeHRMSteps {
	
	public void loginSteps() throws Exception {
		
		LoginPage LP = new LoginPage(Commonmethods.driver, 3);
		LP.fillLoginDetails();
		
	}
	
	public void pimUserSteps() throws Exception {
		
		PimUser  PU = new PimUser(Commonmethods.driver, 4);
		PU.fillPIMUserDetails();
		PU.fillPersonalDetails();
	}
	
	public void adduserSteps() throws Exception {
		
		AdminUserPage AU = new AdminUserPage(Commonmethods.driver, 10);
		AU.fillAdminUserDetails();
	}

	public void logoutStep() throws Exception {
		
		LogoutPage LP = new LogoutPage(Commonmethods.driver, 10);
		LP.logoff();
	}
	
	
	
}
