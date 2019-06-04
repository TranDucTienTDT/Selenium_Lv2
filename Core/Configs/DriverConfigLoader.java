package Configs;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.ini4j.Ini;
import org.ini4j.Profile.Section;

public class DriverConfigLoader {
	public static DriverConfig getDriverConfig(String file,String sectionName) throws Exception 
	{
		Ini ini = new Ini(new FileReader(file));
		Section section = ini.get(sectionName);
		if (section == null) {
			return null;
		}
		
		Map<String, String> propertyMap = new HashMap<String, String>();
		propertyMap.put(DriverConfig.KEY_EXEC_PATH, section.get(DriverConfig.KEY_EXEC_PATH));
		propertyMap.put(DriverConfig.KEY_REMOTE_URL, section.get(DriverConfig.KEY_REMOTE_URL));
		propertyMap.put(DriverConfig.KEY_STARTUP_URL, section.get(DriverConfig.KEY_STARTUP_URL));
		
		DriverConfig config = new DriverConfig();
		config.setName(sectionName);
		config.setProperties(propertyMap);
		
		return config;
	}
	
	public static List<DriverConfig> getAllDriverConfig(String file) throws Exception 
	{
		List<DriverConfig> result = new ArrayList<DriverConfig>();
		Ini ini = new Ini(new FileReader(file));
		Set<Entry<String, Section>> sections = ini.entrySet();
		
		for(Entry<String, Section> sectionEntry : sections) {
			DriverConfig config = new DriverConfig();
			config.setName(sectionEntry.getKey());
			config.setProperties(convertToMap(sectionEntry.getValue().entrySet()));
			
			result.add(config);
		}
		
		return result;
	}
	
	private static Map<String, String> convertToMap(Set<Entry<String, String>> entrySet)
	{
		Map<String, String> map = new HashMap<String, String>();
		for(Entry<String, String> entry : entrySet)
	    {
			map.put(entry.getKey(), entry.getValue());
	    }
		return map;
	}
}
