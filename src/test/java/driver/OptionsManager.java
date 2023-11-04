package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

    public static ChromeOptions chromeOptions(){

        var options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-allow-origins");
        options.addArguments("--disable-popup-blocking");
        if (BrowserManager.HEADLESS.getBool()) options.addArguments("--headless=new");
        return options;
    }

    public static FirefoxOptions firefoxOptions(){

        var options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        if (BrowserManager.HEADLESS.getBool()) options.addArguments("--headless");
        return options;
    }

}