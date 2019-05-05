package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private Logger logger = LogManager.getLogger(Properties.class);

    // There is only one method in the class. It is used to read properties from a given properties file
    public Properties getPropertiesFromFile(String propertiesFileName) {

        //Create an InputStream object that will be used to read the properties file
        InputStream inputStream = null;

        // The Properties object will store properties
        Properties properties = new Properties();
        try {
            logger.info("Trying to load properties with file name: " + propertiesFileName);
            // Read the properties file and initialize the inputStream object
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            // If the properties file does not exist, the inputStream object will be null.
            // Therefore the FileNotFoundException will be thrown
            if (inputStream != null) {
                properties.load(inputStream);
                logger.info("Successfully loaded properties for file: " + propertiesFileName);
            } else {
                throw new FileNotFoundException("Property file: " + propertiesFileName + " not found in the class path");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load properties due to IOException!");
        } finally {
            //At the very end, we close the InputStream by calling the private closeResource method
            closeResource(inputStream);
        }
        return properties;

    }

    private void closeResource(InputStream inputStream) {
        try {
            logger.info("Trying to close InputStream");
            inputStream.close();
            logger.info("Input Stream has been closed");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Cannot close InputStream");
        }
    }


}
