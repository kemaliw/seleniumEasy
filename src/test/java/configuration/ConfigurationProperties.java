package configuration;


import java.util.Properties;

public class ConfigurationProperties {

    // Static field for storing properties
    private static Properties properties;

    private ConfigurationProperties(){

    }

    // The method is used to load the properties object into a static Properties object, available to everyone threads
    public static void setProperties(Properties properties){
        ConfigurationProperties.properties = properties;
    }

    public static Properties getProperties(){
        if (properties==null){
            throw new IllegalStateException("Please set properties using setProperties() before calling getProperties()");
        }
        return properties;
    }

}
