package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MercedesTest {
    @Test
    public void testMercedes() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver"); // Provide the path to your chromedriver executable
        System.setProperty("webdriver.gecko.driver", "src/test/java/driver/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://shop.mercedes-benz.com/en-au/shop/vehicle/srp/demo");

        // Add your Selenium test logic here

        driver.quit();
    }
}
