package page;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PagesFactory extends DriverManager {

  protected PagesFactory(WebDriver driver) {
    PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.driver, 30), this);
  }
}
