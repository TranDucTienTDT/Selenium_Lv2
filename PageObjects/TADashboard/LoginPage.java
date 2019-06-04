package TADashboard;

import static Wrappers.CustomWebElement.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.How;

import Wrappers.Locator;

public class LoginPage {

	//Locator
	private Locator _repoDropdownlist = new Locator(How.XPATH, "//select[@id='repository']");
	private Locator _usernameTextbox = new Locator(How.XPATH, "//input[@id='username']");
	private Locator _passwordTextbox = new Locator(How.XPATH, "//input[@id='password']");
	private Locator _submitButton = new Locator(How.XPATH, "//div[@class='btn-login']");
	
	//Element
	protected void selectRepo(String value) {
		select(_repoDropdownlist.getBy(), "text", value);
	}
	protected void enterText(By textBox ,String value) {
		clear(textBox);
		fill(textBox, value);
	}
	protected void clickButton(By button) {
		click(button);
	}
	
	
	//Method
	public GeneralPage login (String repository, String username, String password) {
		
		selectRepo(repository);		
		enterText(_usernameTextbox.getBy(), username);		
		enterText(_passwordTextbox.getBy(), password);	
		clickButton(_submitButton.getBy());
		
		return new GeneralPage();
	}
	
	
}
