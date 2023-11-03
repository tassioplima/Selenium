package commons;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

  /*
   * Automation method for scrolling down only
   */
  public static  void scrollDown() {
    try {
      Dimension dimensions = driver.manage().window().getSize();
      double screenHeightStart = dimensions.getHeight() * 0.5;
      int scrollStart = (int) screenHeightStart;
      double screenHeightEnd = dimensions.getHeight() * 0.2;
      int scrollEnd = (int) screenHeightEnd;
      Actions touchAction = new Actions(driver);
      touchAction.scrollByAmount(0, 300).release().perform();
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }
  }

  public static  void scrollDownJS() {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,250)","");
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }
  }

}
