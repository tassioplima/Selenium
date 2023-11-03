package driver;

import static config.ConfigurationManager.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
  public static WebDriver driver;

  @BeforeEach
  public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    options.addArguments("--start-fullscreen");
    options.addArguments("--disable-infobars");
    options.addArguments("--remote-allow-origins");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("notCookies");
    WebDriverManager.chromedriver().setup(options);
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(configuration().url());
  }

  @AfterEach
  public void quit() {
    driver.quit();
  }
}
