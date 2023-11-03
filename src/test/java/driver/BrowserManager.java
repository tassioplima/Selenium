package driver;

import static config.ConfigurationManager.configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public enum BrowserManager {
  CHROME {
    @Override
    public WebDriver createLocalDriver() {
      WebDriverManager.chromedriver().setup();
      return new ChromeDriver(getOptions());
    }

    @Override
    public ChromeOptions getOptions() {
      var chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("START_MAXIMIZED");
      chromeOptions.addArguments("DISABLE_INFOBARS");
      chromeOptions.addArguments("DISABLE_NOTIFICATIONS");
      chromeOptions.addArguments("REMOTE_ALLOW_ORIGINS");

      if (configuration().headless()) chromeOptions.addArguments("CHROME_HEADLESS");

      return chromeOptions;
    }
  },
  FIREFOX {
    @Override
    public WebDriver createLocalDriver() {
      WebDriverManager.firefoxdriver().setup();

      return new FirefoxDriver(new FirefoxOptions());
    }

    @Override
    public FirefoxOptions getOptions() {
      var firefoxOptions = new FirefoxOptions();
      firefoxOptions.addArguments("START_MAXIMIZED");

      if (configuration().headless()) firefoxOptions.addArguments("GENERIC_HEADLESS");

      return firefoxOptions;
    }
  };

  public abstract WebDriver createLocalDriver();

  public abstract AbstractDriverOptions<?> getOptions();
}
