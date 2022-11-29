package helper_classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

public final class GlobalSettings {

	private static InputStream propertyFileStream;
	private static Properties property;
	private static GlobalSettings setting;
	
	private String currentDirectory; 

	private GlobalSettings() {
		InetAddress localHost;
		String hostIPAddress;	
		property = new Properties();
		try {
			localHost = InetAddress.getLocalHost();			 
			hostIPAddress = localHost.getHostAddress();
			System.out.println("Host IP Address: " + hostIPAddress);
			
			currentDirectory = System.getProperty("user.dir");
			System.out.println("Project location: " + currentDirectory);
			property.load(new FileInputStream(new File("./src/test/resources/properties/ICTERGuruWebAppGlobalSettings.properties")));
			// ./src/test/resources/properties/ICTERGuruWebAppGlobalSettings.properties

			if (propertyFileStream != null) {
				property.load(propertyFileStream);
			}
						
		} catch(IOException io) {
			System.err.println(io.getMessage());
		}
	}

	public static GlobalSettings getInstance() {
		if (setting != null)
		{
			return setting;
		}
		else
		{
			return new GlobalSettings();
		}
	}

	/**
	 * Retrieves the value for a given property name.
	 *
	 * @param name
	 *            name of property's key
	 * @return value of property
	 */
	public String getProperty(String name) throws Exception {
		return property.getProperty(name).toString();
	}
}
