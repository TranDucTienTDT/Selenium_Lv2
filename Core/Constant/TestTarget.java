package Constant;

public enum TestTarget {
	
	UNSUPPORTED,
	NATIVE,
    CHROME,
    FIREFOX,
    EDGE;// other here...
    
    public static TestTarget fromString(String mode)
    {
    	if("chrome".equalsIgnoreCase(mode)){
			return TestTarget.CHROME;
		}
		else if("firefox".equalsIgnoreCase(mode)){
			return TestTarget.FIREFOX;
		}
		else if("native".equalsIgnoreCase(mode)){
			return TestTarget.NATIVE;
		}
		
		return TestTarget.UNSUPPORTED;
    }
    
    public DriverType toDriverType() {
    	
    	if(this == NATIVE)
			return DriverType.NATIVE_MOBILE;
    	
		else if(this == CHROME)
			return DriverType.CHROME;
    	
		else if(this == FIREFOX)
			return DriverType.FIREFOX;
    	
		else if(this == EDGE)
			return DriverType.EDGE;
		
		return null;
    }

    public String toString()
    {
    	return this.name().toLowerCase();
    }

}
