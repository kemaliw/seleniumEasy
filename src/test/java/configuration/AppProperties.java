package configuration;

public class AppProperties {

    // The method returns a property named app.url by calling the getProperty method on the object returned by
    // the getProperties method from the ConfigurationProperties class

    public static String getAllUrl(){
        return ConfigurationProperties.getProperties().getProperty("app.url");
    }
}
