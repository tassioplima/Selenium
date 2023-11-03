package commons;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Commons extends DriverManager {

  public static Duration duration = Duration.ofSeconds(30);

  public static void waitForVisibilityElement(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitForInvisibilityElement(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public static void waitForElementToBeClickable(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void waitForElementFromShadow(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, duration);
  }
}
