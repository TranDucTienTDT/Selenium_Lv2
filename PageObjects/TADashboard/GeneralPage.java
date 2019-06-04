package TADashboard;

import static Wrappers.CustomWebDriver.*;

public class GeneralPage {
	//Locators
	//Elements
	//Methods
	public String getPageTitle() {
		return getTitle();
	}

	public String getPopText() {
		return switchToAlertGetText();
	}
}
