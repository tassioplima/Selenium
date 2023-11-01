package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
public class BaseWeb {
    protected WebDriver driver;

    @Parameter({"browser"})
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
        DriverManager.getDriver().get(configuration().url());
    }


}
