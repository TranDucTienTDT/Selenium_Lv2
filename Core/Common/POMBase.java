package Common;

import java.util.Map;

import TADashboard.LoginPage;
import Wrappers.Locator;
import Wrappers.LocatorLoader;

public abstract class POMBase {
	
	private Map<String, Locator> locators = null;
	
	public BasePOM(Class<?> derivedClass)
	{
		String platform = TestExecutor.getInstance().getEnvironmentConf().getPlatform().toString();
		String target = TestExecutor.getInstance().getEnvironmentConf().getRunTarget().toString();
		locators = LocatorLoader.getLocatorsByClassName(LoginPage.class, platform, target);
		
		initPageElements();
	}
	
	protected Locator getLocator(String elementName)
	{
		return locators.get(elementName);
	}
	
	public abstract void initPageElements();

}
