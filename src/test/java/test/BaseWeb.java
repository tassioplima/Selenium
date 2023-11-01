package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BaseWeb {
    protected WebDriver driver;

    @BeforeEach
    public void setup(String browserName){
        switch (browserName){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        DriverManager.getDriver().get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo");
    }


}
