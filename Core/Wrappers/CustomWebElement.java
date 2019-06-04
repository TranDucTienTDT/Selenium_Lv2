package Wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static Wrappers.CustomWebDriver.*;

public class CustomWebElement {

	public static void fill(By locator, String withString) {
		getWebElement(locator).sendKeys(withString);
	}
	
	public static void click(By locator) {
		getWebElement(locator).click();
	}
	
	public static void clear(By locator) {
		getWebElement(locator).clear();
	}
	
	public static void select(By locator, String selectBy, String value){
        Select dropdown = new Select(getWebElement(locator));

        if(selectBy == "index"){
            dropdown.selectByIndex(Integer.parseInt(value));
        } else if(selectBy == "value"){
            dropdown.selectByValue(value);
        } else if(selectBy == "text"){
            dropdown.selectByVisibleText(value);
        } else {
            System.out.println("Cannot define!");
        }

    }
	
	public static String getText(By locator) {
		return getWebElement(locator).getText();
	}
	
    public static void getAttribute(By locator, String attribute){
    	getWebElement(locator).getAttribute(attribute);
    }
    
    
}
