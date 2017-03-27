package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kolja on 25.03.2017.
 */
public class WebConnect {

    private WebDriver driver;


    public WebConnect(){
        System.setProperty("webdriver.firefox.marionette","D:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void setText(String text, String destination){
        driver.findElement(By.xpath(destination)).sendKeys(text);
    }

    public void connectTo(String url){
        driver.get(url);
    }



    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {

        return driver;
    }


}
