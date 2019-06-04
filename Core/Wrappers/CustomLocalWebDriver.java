package Wrappers;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import Configs.DriverConfig;
import Constant.DriverType;
import static Constant.Constant.*;
import static Common.Utilities.*;

public class CustomLocalWebDriver extends CustomWebDriver {
	
	
	public CustomLocalWebDriver(DriverType type, DriverConfig driverConfig) {
		try {
			String exeDriverPath = driverConfig.getProperty(DriverConfig.KEY_EXEC_PATH);
			switch (type) 
			{
				case CHROME:
					this.createChromeDriver_Windows(exeDriverPath);
					break;
	
				case FIREFOX:
					this.createFirefoxDriver_Windows(exeDriverPath);
					break;
					
				case EDGE:
					this.createEdgeDriver_Windows(exeDriverPath);
					break;
					
				default:
					System.out.println("Cannot define!");
					break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createChromeDriver_Windows(String exeDriverPath) throws Exception {
		
		String driverFilePath = getProjectPath() + File.separator + exeDriverPath;
		System.setProperty("webdriver.chrome.driver", driverFilePath);
        
        ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		_driver = new ChromeDriver(options);
	}
	
	private void createFirefoxDriver_Windows(String exeDriverPath) throws Exception {
		
		String driverFilePath = getProjectPath() + File.separator + exeDriverPath;
		System.setProperty("webdriver.gecko.driver", driverFilePath);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.setProfile(new FirefoxProfile());
		
		_driver = new FirefoxDriver(options);
		maximizeWindow();
	}
	
	private void createEdgeDriver_Windows(String exeDriverPath) throws Exception {
		
		String driverFilePath = getProjectPath() + File.separator + exeDriverPath;
		System.setProperty("webdriver.edge.driver", driverFilePath);
		
		_driver = new EdgeDriver();
		maximizeWindow();
	}
}
