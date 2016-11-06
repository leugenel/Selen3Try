import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by eugenel on 11/2/16.
 */
public class Epoch {

    WebDriver driver;

    public Epoch(WebDriver driver){
        this.driver=driver;
    }

    public String getEpochData() {
        WebElement clockField = driver.findElement(By.id("ecclock"));
        return clockField.getText();
    }

    public String getGMT(){
        WebElement fieldGMT = driver.findElement(By.id("result1"));
        return fieldGMT.getText();
    }

    public void clickTimeStamp(){
        WebElement bTimestamp = driver.findElement(By.xpath("//*[@id=\"ef\"]/button[1]"));
        bTimestamp.click();
    }

    public String getTimeZone(){
        WebElement fieldTimeZone = driver.findElement(By.xpath("//*[@id=\"result1\"]/a"));
        return fieldTimeZone.getText();
    }

    //Get current date 01/01/2016 00:00
    public String getDate(){

        WebElement fieldYear = driver.findElement(By.id("hcinput"));
        WebElement fieldMonth = driver.findElement(By.id("mm"));
        WebElement fieldDay = driver.findElement(By.name("dd"));
        WebElement fieldHour = driver.findElement(By.name("hh"));
        WebElement fieldMin = driver.findElement(By.name("mn"));
        WebElement fieldSec = driver.findElement(By.name("ss"));

        return " Year: "+fieldYear.getAttribute("value")+
                " Month: "+fieldMonth.getAttribute("value")+
                " Day: "+fieldDay.getAttribute("value")+
                " Hour: "+fieldHour.getAttribute("value")+
                " Minutes: "+fieldMin.getAttribute("value")+
                " Seconds: "+fieldSec.getAttribute("value");
    }

    //Clear all the data from the page
    public void clear(){
        WebElement link = driver.findElement(By.xpath("//*[@id=\"contentcolumn\"]/div[2]/p[3]/a"));
        link.click();
    }

    //Set 2016 year beginning
    public void setDate(){

        WebElement fieldYear = driver.findElement(By.id("hcinput"));
        WebElement fieldMonth = driver.findElement(By.id("mm"));
        WebElement fieldDay = driver.findElement(By.name("dd"));
        WebElement fieldHour = driver.findElement(By.name("hh"));
        WebElement fieldMin = driver.findElement(By.name("mn"));
        WebElement fieldSec = driver.findElement(By.name("ss"));

        fieldYear.sendKeys("2016");
        fieldMonth.sendKeys("01");
        fieldDay.sendKeys("01");
        fieldHour.sendKeys("01");
        fieldMonth.sendKeys("00");
        fieldMin.sendKeys("00");
        fieldSec.sendKeys("00");

    }

    //Receive timestamp of the 2016 beginning
    public String getTimeStamp(){
        WebElement bToTimestamp = driver.findElement(By.xpath("//*[@id=\"hf\"]/table[3]/tbody/tr/td/button"));
        WebElement Timestamp2016 = driver.findElement(By.id("result2"));
        bToTimestamp.click();
        return Timestamp2016.getText();
    }


}
