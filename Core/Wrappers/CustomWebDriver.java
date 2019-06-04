package Wrappers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWebDriver {
	
	protected static WebDriver _driver;

	public static void openBrowser(String browserName) {
		switch (browserName){
		case "Chrome":
			//System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
			_driver = new ChromeDriver();
			break;
		case "Firefox":
			_driver = new FirefoxDriver();
			break;
		case "Egde":
			_driver = new EdgeDriver();
			break;
		case "IE":
			_driver = new InternetExplorerDriver();
			break;
		case "Safari":
			_driver = new SafariDriver();
			break;
		case "Coccoc":
			System.out.println("mo coccoc");
			break;
		default:
			System.out.println(browserName+" cannot define!");
		}
	}
	
	public static void maximizeWindow() {
		_driver.manage().window().maximize();
	}
	
	public void visitPage(String url) {
		_driver.get(url);
	}

	public static void navigateTo(String url) {
		_driver.navigate().to(url);
	}
	
	public String getCurrentUrl() {
		return _driver.getCurrentUrl();
	}

	public static WebElement getWebElement(By locator) {
		return _driver.findElement(locator);
	}
	

	public static List<WebElement> getAllWebElements(By locator){
		return _driver.findElements(locator);
	}
	
	public static String getTitle() {
		return _driver.getTitle();
	}
	
	public static String switchToAlertGetText() {
		return _driver.switchTo().alert().getText();
	}
	
	public void quit(){
        if (_driver != null){
        	_driver.quit();
        }
	}
	
	public static void close(){
        
        if (_driver != null){
        	_driver.close();
        }
    }
	
	
	public WebElement waitForPresent(By locator, int timeOutInSeconds) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(_driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception error) {
			throw error;
		}
		return element;
	}

}
