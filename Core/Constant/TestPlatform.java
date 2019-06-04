package Constant;

public enum TestPlatform {
	UNSUPPORTED,
    ANDROID,
    IOS,
    WINDOWS,
    LINUX,
    MAC;
    
    public static TestPlatform fromString(String mode)
    {
    	if("windows".equalsIgnoreCase(mode)){
			return TestPlatform.WINDOWS;
		}		
		else if("linux".equalsIgnoreCase(mode)){
			return TestPlatform.LINUX;
		}
		else if("mac".equalsIgnoreCase(mode)){
			return TestPlatform.MAC;
		}
		else if("android".equalsIgnoreCase(mode)){
			return TestPlatform.ANDROID;
		}
		else if("ios".equalsIgnoreCase(mode)){
			return TestPlatform.IOS;
		}
		
		return TestPlatform.UNSUPPORTED;
    }
    
    public String toString()
    {
    	return this.name().toLowerCase();
    }
}
