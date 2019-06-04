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
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constant.Constant.*;

public class CustomWebDriver {

	public static void openBrowser(String browserName) {
		switch (browserName){
		case "Chrome":
			//System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
			WEBDRIVER = new ChromeDriver();
			break;
		case "Firefox":
			WEBDRIVER = new FirefoxDriver();
			break;
		case "Egde":
			WEBDRIVER = new EdgeDriver();
			break;
		case "IE":
			WEBDRIVER = new InternetExplorerDriver();
			break;
		case "Safari":
			WEBDRIVER = new SafariDriver();
			break;
		case "Coccoc":
			System.out.println("mo coccoc");
			break;
		default:
			System.out.println(browserName+" cannot define!");
		}
	}
	
	public static void maximizeWindow() {
		WEBDRIVER.manage().window().maximize();
	}
	
	public static void visitPage(String url) {
		WEBDRIVER.get(url);
	}

	public static void navigateTo(String url) {
		WEBDRIVER.navigate().to(url);
	}
	
	public String getCurrentUrl() {
		return WEBDRIVER.getCurrentUrl();
	}

	public static WebElement getWebElement(By locator) {
		return WEBDRIVER.findElement(locator);
	}
	

	public static List<WebElement> getAllWebElements(By locator){
		return WEBDRIVER.findElements(locator);
	}
	
	public static String getTitle() {
		return WEBDRIVER.getTitle();
	}
	
	public static String switchToAlertGetText() {
		return WEBDRIVER.switchTo().alert().getText();
	}
	
	public static void quit(){
        if (WEBDRIVER != null){
            WEBDRIVER.quit();
        }
	}
	
	public static void close(){
        
        if (WEBDRIVER != null){
        	WEBDRIVER.close();
        }
    }
	
	
	public WebElement waitForPresent(By locator, int timeOutInSeconds) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(WEBDRIVER, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception error) {
			throw error;
		}
		return element;
	}

}
