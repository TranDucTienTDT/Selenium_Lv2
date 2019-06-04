package Common;

import java.io.File;
import java.util.List;

import org.testng.ITestContext;

import Configs.DriverConfig;
import Configs.DriverConfigLoader;
import Configs.TestEnvironmentConfig;
import Constant.TestPlatform;
import Wrappers.CustomWebDriver;
import Wrappers.DriverManager;

import static Constant.Constant.*;
import static Common.Utilities.*;


public class TestExecutor {
	private static TestExecutor _instance = null;

	public static TestExecutor getInstance(){ 
		if (_instance == null) 
			_instance = new TestExecutor(); 

		return _instance; 
	} 

	private TestEnvironmentConfig currentEnvironment = null;
	private List<DriverConfig> driverConfigList = null;
	private DriverConfig driverConfig = null;

	private TestExecutor(){}

	public void initialize(ITestContext context) {
		// set execution environment from setting value in xml file.
		String env = context.getCurrentXmlTest().getParameter("environment");
		setCurrentConfig(env);

		// create driver object based on the environment configuration
		initDriver();
	}
	
	private void initDriver() 
	{
		driverConfig = getDriverConfig();
		
		if(isMobileTesting()) {
			DriverManager.getInstance().createRemoteDriver(currentEnvironment, driverConfig);
		}
		else {
			String remoteURL = "";
			if(driverConfig != null)
				remoteURL = driverConfig.getProperty(DriverConfig.KEY_REMOTE_URL);
			
			if(remoteURL.isEmpty()) {
				DriverManager.getInstance().createLocalDriver(currentEnvironment, driverConfig);
			}
			else {
				DriverManager.getInstance().createRemoteDriver(currentEnvironment, driverConfig);
			}
		}
	}
	
	public boolean isMobileTesting() {
		if(currentEnvironment != null) {
			if(currentEnvironment.getPlatform() == TestPlatform.ANDROID || 
				currentEnvironment.getPlatform() == TestPlatform.IOS)
				return true;
		}
		return false;
	}
	
	public TestEnvironmentConfig getEnvironmentConf() {
		return currentEnvironment;
	}
	
	public void setCurrentConfig(String environmentConf) 
	{
		this.currentEnvironment = new TestEnvironmentConfig(environmentConf);
		
		if(driverConfigList == null) {
			try {
				String driverFilePath = getProjectPath() + File.separator + CONFIG_FILE_DRIVER;
				driverConfigList = DriverConfigLoader.getAllDriverConfig(driverFilePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public DriverConfig getDriverConfig() {
		if(this.currentEnvironment != null)
			return getDriverConfig(this.currentEnvironment.getEnvConfigString());
		return null;
	}
	

	public DriverConfig getDriverConfig(String environmentConf) {
		if(driverConfigList != null) {
			for(DriverConfig config : driverConfigList) {
				if(config.getName().equalsIgnoreCase(environmentConf))
					return config;
			}
		}
		return null;
	}
	public CustomWebDriver getCurrentDriver() {
		return DriverManager.getInstance().getCurrentDriver(this.currentEnvironment);
	}
}
