package driver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo");
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}