package browser;

import configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFireFoxWebDriverLocation());
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", LocalWebDriverProperties.getIEWebDriverLocation());
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknow browser type. Please check your configuration");
        }
    }
}
