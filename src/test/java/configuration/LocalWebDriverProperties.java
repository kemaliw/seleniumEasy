package configuration;

import sun.security.krb5.Config;

public class LocalWebDriverProperties {

    //Get Chrome location
    public static String getChromeWebDriverLocation(){
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    //Get FireFox location
    public static String getFireFoxWebDriverLocation(){
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }

    //Get IE location
    public static String getIEWebDriverLocation(){
        return ConfigurationProperties.getProperties().getProperty("ie.driver.location");
    }
}
