package Common;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Configs.DriverConfig;
import Wrappers.CustomWebDriver;
import Wrappers.DriverManager;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import static Wrappers.CustomWebDriver.*;

import java.lang.reflect.Method;
import java.util.Collection;

import static Constant.Constant.*;

public class TestBase {

  //@BeforeMethod
  public void beforeMethod() {
	  openBrowser("Chrome");
	  visitPage(DASHBOARD_URL);
	  maximizeWindow();
  }

  //@AfterMethod
  public void afterMethod() {
	  quit();
  }
  
  
  @Parameters({ "environment" })
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser, Method method, ITestContext context) throws Throwable {
		
		try {
			TestExecutor.getInstance().initialize(context);
			
			if(TestExecutor.getInstance().isMobileTesting() == false) {
				// open browser and navigate to startup URL
				DriverConfig drvConfig = TestExecutor.getInstance().getDriverConfig();
				
				if(drvConfig != null && drvConfig.hasProperty(DriverConfig.KEY_STARTUP_URL))
				{
					String startupURL = drvConfig.getProperty(DriverConfig.KEY_STARTUP_URL);
					TestExecutor.getInstance().getCurrentDriver().visitPage(startupURL);
				}
			}
			
		} catch (Exception e) {
		    //LOG.warning(e.toString());
		}
	}
	
	
	@AfterMethod(alwaysRun = true)
	 public void cleanUp(ITestResult result) 
	{
		Collection<CustomWebDriver> drivers = DriverManager.getInstance().getAllDrivers();
		for(CustomWebDriver driver : drivers) {
			try {
				driver.quit();
			}
			catch (Exception e) {
				e.printStackTrace();
		    }
		}
	}

}
