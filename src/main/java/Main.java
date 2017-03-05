
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Main {

    static public WebDriver driver;

    public static void main(String[] args) {

        driver = (new Driver(Driver.Browser.SAFARI)).getDriver();

        driver.navigate().to("http://www.epochconverter.com/");

        waitForLoad(driver);

        driver.manage().window().maximize();

        Epoch epoch = new Epoch(driver);

        //Read the epoch time
        System.out.println("Epoch date:" +epoch.getEpochData());

        //Lets try to take GMT before it shown
        //Read the epoch time
        System.out.println("GMT still not shown "+ epoch.getGMT());

        //Click on the converter
        epoch.clickTimeStamp();

        //Read the epoch time
        System.out.println("Current " + epoch.getGMT());

        //Read Time Zone
        System.out.println("Your time Zone: " + epoch.getTimeZone());

        //Get date
        System.out.println("Current date: " + epoch.getDate());


        epoch.clear();

        epoch.setDate();

        //epoch.getTimeStamp();

        System.out.println("The timestamp of 01/01/2016: " + epoch.getTimeStamp());

        if(driver!=null) {
            driver.close();
            System.out.println("Driver closed - bye bye");
        }

    }

    static void  waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 50).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
