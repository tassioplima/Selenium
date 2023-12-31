package page;

import commons.Commons;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WikipediaPage extends PagesFactory {
  private WebDriver driver;

  public WikipediaPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(name = "search")
  private WebElement searchInput;

  @Step
  public void search(String text) {
    searchInput.sendKeys(text);
  }

}