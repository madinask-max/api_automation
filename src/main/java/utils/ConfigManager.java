package utils;


import java.io.InputStream;
import java.util.Properties;


public class ConfigManager {

	
	 private static Properties prop = new Properties();

	    static {
	        try {
	            InputStream input = ConfigManager.class
	                    .getClassLoader()
	                    .getResourceAsStream("config.properties");

	            if (input == null) {
	                throw new RuntimeException("config.properties NOT FOUND in resources folder");
	            }
	            
	            prop.load(input);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to load config.properties", e);
	        }
	    }

	    public static String get(String key) {
	        return prop.getProperty(key);
	    }
	    
	    
}
