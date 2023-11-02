package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static config.ConfigurationManager.configuration;

public class DriverManager {
    public static WebDriver driver;

    @BeforeEach
    public void setup(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("notCookies");
        WebDriverManager.chromedriver().setup();
        Cookie cookie = new Cookie("at_check", "true");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(configuration().url());
        driver.manage().addCookie(cookie);
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }
}