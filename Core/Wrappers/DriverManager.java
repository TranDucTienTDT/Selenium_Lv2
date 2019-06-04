package Wrappers;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Configs.DriverConfig;
import Configs.TestEnvironmentConfig;
import Constant.DriverType;


public class DriverManager {// singleton
	
	private static DriverManager _instance = null;
	  
    public static DriverManager getInstance(){ 
        if (_instance == null) 
        	_instance = new DriverManager(); 
  
        return _instance; 
    } 
    
    private Map<String, CustomWebDriver> map = new ConcurrentHashMap<String, CustomWebDriver>();
    
    public void createLocalDriver(TestEnvironmentConfig currentEnvironment, DriverConfig driverConfig) 
	{
		String envName = currentEnvironment.getEnvConfigString();
		DriverType type = currentEnvironment.getRunTarget().toDriverType();
		
		CustomLocalWebDriver driver = new CustomLocalWebDriver(type, driverConfig);
		map.put(envName, driver);
	}
    
	public void createRemoteDriver(TestEnvironmentConfig currentEnvironment, DriverConfig driverConfig) {
		String envName = currentEnvironment.getEnvConfigString();
		DriverType type = currentEnvironment.getRunTarget().toDriverType();
		
		CustomRemoteWebDriver driver = new CustomRemoteWebDriver(type, driverConfig);
		map.put(envName, driver);
	}
	
	public CustomWebDriver getCurrentDriver(TestEnvironmentConfig currentEnvironment) {
		String envName = currentEnvironment.getEnvConfigString();
		return map.get(envName);
	}
	
	public Collection<CustomWebDriver> getAllDrivers(){
		return map.values();
	}

}
