package commons;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

  public static void waitForElementFromShadow(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, duration);
  }

  public static void moveToElement (WebElement element) {
    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();
  }

  public static void moveToElementByCSS (String elementSelect) {
    WebElement element = driver.findElement(By.cssSelector(elementSelect));
    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();
  }
  public static void moveToElementByWebElement (WebElement element) {
    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();
  }
}
