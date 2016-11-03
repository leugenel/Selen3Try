import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

/**
 * Created by eugenel on 11/3/16.
 */
public class Driver {

    public enum Browser {
        FIREFOX,
        SAFARI
    }

    WebDriver driver;
    String driverPath = "";
    String driverName = "";

    public Driver(Browser browser){
         switch (browser){
            case FIREFOX:
                setFireFox();
                break;
            case SAFARI:
                setSafari();
                break;
        }

    }

    public WebDriver getDriver(){
         return driver;
     }

    void setFireFox(){
        driverPath = "/Users/eugenel/Documents/Code/Selen3Try/";
        driverName = "geckodriver";

        System.out.println("launching firefox browser");
        System.setProperty("webdriver.gecko.driver", driverPath+driverName);

        File pathToBinary = new File("/Applications/Firefox49.app/Contents/MacOS/firefox-bin");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        driver = new FirefoxDriver(ffBinary,firefoxProfile);

    }

    void setSafari(){
        driverPath = "/usr/bin/";
        driverName = "safaridriver";

        System.out.println("launching safari browser");

        driver = new SafariDriver();

    }

}
