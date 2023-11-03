package driver;

import static config.ConfigurationManager.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
  public static WebDriver driver;

  @BeforeEach
  public void setup() throws Exception{

    String browser = BrowserManager.BROWSER.getEnv();

    switch (browser){

      case "chrome":
        if(!BrowserManager.HEADLESS.getEnv()){
            driver = new ChromeDriver(OptionsManager.chromeOptions());
        } else {
            driver = new ChromeDriver(OptionsManager.chromeOptionsHeadless());
        }
        WebDriverManager.chromedriver().setup();
s        break;

      case "firefox":

        if(!BrowserManager.HEADLESS.getEnv()){
          driver = new FirefoxDriver(OptionsManager.firefoxOptions());
        } else {
          driver = new FirefoxDriver(OptionsManager.firefoxOptionsHeadless());
        }
        WebDriverManager.firefoxdriver().setup();
        break;

      default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(configuration().url());

  }

  @AfterEach
  public void quit() {
    driver.quit();
  }

}
