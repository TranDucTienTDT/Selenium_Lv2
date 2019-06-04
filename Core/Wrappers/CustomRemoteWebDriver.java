package Wrappers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constant.Constant.*;

import Configs.DriverConfig;
import Constant.DriverType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class CustomRemoteWebDriver extends CustomWebDriver {

	public CustomRemoteWebDriver(DriverType type, DriverConfig driverConfig) {
		try {
			String remoteURL = driverConfig.getProperty(DriverConfig.KEY_REMOTE_URL);
			switch (type)
			{
			case NATIVE_MOBILE:
				this.createMobileDriver(remoteURL);
				break;

			case CHROME: 
				this.createRemoteChromeDriver_Windows(remoteURL);
				break;

			case FIREFOX: 
				this.createRemoteFirefoxDriver_Windows(remoteURL);
				break;

			case EDGE: 
				this.createRemoteEdgeDriver_Windows(remoteURL);
				break;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void createRemoteChromeDriver_Windows(String remoteURL) throws MalformedURLException {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
	
		options.addArguments("start-maximized");
	
		WEBDRIVER = new RemoteWebDriver(new URL(remoteURL), options);
	}
	
	private void createRemoteFirefoxDriver_Windows(String remoteURL) throws MalformedURLException {
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.setProfile(new FirefoxProfile());
		
		WEBDRIVER = new RemoteWebDriver(new URL(remoteURL), options);
		maximizeWindow();
	}
	
	private void createRemoteEdgeDriver_Windows(String remoteURL) throws MalformedURLException {
		
		EdgeOptions options = new EdgeOptions();
		WEBDRIVER = new RemoteWebDriver(new URL(remoteURL), options);
		maximizeWindow();
		
	}
	
	private void createMobileDriver(String remoteURL) throws MalformedURLException {
		
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("deviceName", "Android");
//		caps.setCapability("platformName", "Android");
//		caps.setCapability("appPackage", "com.sec.android.app.shealth");
//		caps.setCapability("appActivity","com.sec.android.app.shealth.SplashScreenActivity");
//		caps.setCapability("automationName", "UiAutomator2");
//		WEBDRIVER = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		
	}

}
