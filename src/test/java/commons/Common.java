package commons;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Common  {

    public static final int DEFAULT_SCROLL_COUNT = 15;
    public static Duration duration = Duration.ofSeconds(30);

    public static void waitForVisibilityElement(WebDriver element) {
        //WebDriverWait wait = new WebDriverWait(driver, duration);
       // wait.until(ExpectedConditions.visibilityOf(element));
    }
}
