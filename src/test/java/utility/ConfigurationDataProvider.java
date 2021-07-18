package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigurationDataProvider {

	Properties config = new Properties();
	Properties OR = new Properties();
	Properties Dfile = new Properties();
	File configSrc = new File("./src/test/resources/properties/Config.properties");
	File objectRepo = new File("./src/test/resources/properties/OR.properties");
	File data = new File("./src/test/resources/properties/Data.properties");

	public ConfigurationDataProvider() {

		try {
			FileInputStream configFile = new FileInputStream(configSrc);
			// pro = new Properties();
			config.load(configFile);
		} catch (Exception e) {
			System.out.println("Not able to load Config properties file");
		}

		try {
			FileInputStream ORfile = new FileInputStream(objectRepo);
			// pro = new Properties();
			OR.load(ORfile);
		} catch (Exception e) {
			System.out.println("Not able to load OR properties file");
		}

		try {
			FileInputStream datafile = new FileInputStream(data);
			// pro = new Properties();
			Dfile.load(datafile);
		} catch (Exception e) {
			System.out.println("Not able to load data properties file");
		}
	}

	public String getFromObjectRepo(String KeyToSearch) {
		return OR.getProperty(KeyToSearch);
	}

	public String getFromConfig(String KeyToSearch) {
		return config.getProperty(KeyToSearch);
	}

	public String getFromData(String KeyToSearch) {
		return Dfile.getProperty(KeyToSearch);
	}

	public void setIntoConfig(String key, String valueToAdd) {
		try {
			OutputStream outputFile = new FileOutputStream(configSrc);
			config.setProperty(key, valueToAdd);
			config.store(outputFile, null); // in place of "null" - comment can be added
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public void setIntoData(String key, String valueToAdd) {
		try {
			OutputStream outputFile = new FileOutputStream(data);
			Dfile.setProperty(key, valueToAdd);
			Dfile.store(outputFile, null); // in place of "null" - comment can be added
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
