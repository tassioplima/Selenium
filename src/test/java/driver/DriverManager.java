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
        driver = new ChromeDriver(OptionsManager.chromeOptions());
        WebDriverManager.chromedriver().setup();
        break;

      case "firefox":
        driver = new FirefoxDriver(OptionsManager.firefoxOptions());
        WebDriverManager.firefoxdriver().setup();
        break;

      default:
        driver = new ChromeDriver(OptionsManager.chromeOptions());
        WebDriverManager.chromedriver().setup();
    }

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(configuration().url());

  }

  @AfterEach
  public void quit() {
    driver.quit();
  }

}
