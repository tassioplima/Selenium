package commons;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Common extends DriverManager {

    public static final int DEFAULT_SCROLL_COUNT = 15;
    public static Duration duration = Duration.ofSeconds(30);

    public static void waitForVisibilityElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForInvisibilityElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
