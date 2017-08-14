package utilityFiles;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {/*

	Properties prop = new Properties();

	public Properties bringObjectProperty() throws IOException {
		FileInputStream stream = new FileInputStream(new File(
				System.getProperty("user.dir")
						+ "\\src\\main\\java\\resources\\config.properties"));
		prop.load(stream);

		System.out.println("Here is property from config file-->" + prop.getProperty("enviornment"));
		return prop;
	}*/

    private static HashMap<String, String> propertyMap = new PropertyReader().getProperties();

    public PropertyReader() {
        propertyMap = getPropValues();
    }

    public static synchronized HashMap<String, String> getProperties() {
        return propertyMap;
    }

    /**
     * get all the properties value present in config.properties
     *
     * @return hash map consisting all properties in key.value pair
     */
    private HashMap<String, String> getPropValues() {
        HashMap<String, String> result = new HashMap<String, String>();

        try {
            Properties prop = new Properties();
        /*	String propFileName = "config.properties";

			InputStream inputStream= getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null)
			{
				prop.load(inputStream);
		*/
            FileInputStream stream = new FileInputStream(new File(
                    System.getProperty("user.dir")
                            + "\\src\\main\\java\\resources\\config.properties"));
            prop.load(stream);
			/*}
			else
			{
				throw new FileNotFoundException("Property file '" + propFileName + "' not found in the classpath");
			}
*/
            //E:\MyNewFramework\src\main\java\resources\testdata\PSATestData.xml
            //E:\MyNewFramework\src\main\java\resources\config.properties
            // get the property values
            Set propNames = prop.stringPropertyNames();
            Iterator<String> iterator = propNames.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                result.put(key, prop.getProperty(key));
            }

            stream.close();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
