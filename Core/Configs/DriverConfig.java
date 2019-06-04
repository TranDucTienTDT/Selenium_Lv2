package Configs;

import java.util.Map;

public class DriverConfig {

	private String _name;
	private Map<String, String> _properties=null;
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}
	
	public void setProperties(Map<String, String> properties) {
		this._properties = properties;
	}
	
	public Map<String, String> getProperties() {
		return _properties;
	}
	
	public boolean hasProperty(String propertyName) {
		return _properties.containsKey(propertyName);
	}
	
	public String getProperty(String propertyName) {
		if(_properties.containsKey(propertyName))
			return _properties.get(propertyName);
		return "";
	}
	

	public static final String KEY_EXEC_PATH = "capability.executable_path";
	public static final String KEY_REMOTE_URL = "capability.remoteserver";
	public static final String KEY_STARTUP_URL = "capability.startup_url";
	
}
