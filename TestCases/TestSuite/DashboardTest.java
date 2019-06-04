package TestSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.TestBase;
import TADashboard.GeneralPage;
import TADashboard.LoginPage;

import static Constant.Constant.*;

public class DashboardTest extends TestBase{

	@Test
	public void TC001_LoginWithCorrectCredentials_Test() {
		System.out.println("Verify user can log in specific repository successfully via Dashboard login page with correct credentials");
		String actualResult = new LoginPage().login(DASHBOARD_REPOSITORY, DASHBOARD_USERNAME, DASHBOARD_PASSWORD)
				.getPageTitle();
		String expectedResult = "TestArchitect ™ - Execution Dashboard";
		Assert.assertEquals(actualResult, expectedResult, "The message is not displayed as expected");
	}

	//@Test
	public void TC002_NoInputUsernamePassword_Test() {
		System.out.println("Verify the page works correctly for the case when no input entered to Password and Username field");
		new LoginPage().login(DASHBOARD_REPOSITORY, "", "");
		String actualResult = new GeneralPage().getPopText();
		String expectedResult = "Please enter username!";
		Assert.assertEquals(actualResult, expectedResult, "The message is not displayed as expected");
	}
	
	//@Test
	public void TC003_NoInputUsernamePassword_Test() {
		System.out.println("Verify the newly added main parent page is positioned at the location specified as set with \"Displayed After\" field of \"New Page\" form on the main page bar/\"Parent Page\" dropped down menu");
		new LoginPage().login(DASHBOARD_REPOSITORY, "", "");
		String actualResult = new GeneralPage().getPopText();
		String expectedResult = "Please enter username!";
		Assert.assertEquals(actualResult, expectedResult, "The message is not displayed as expected");
	}
	
	


}
