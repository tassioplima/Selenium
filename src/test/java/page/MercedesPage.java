package page;

import commons.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.table.TableRowSorter;
import java.util.List;

public class MercedesPage extends PagesFactory {
  private WebDriver driver;

  public MercedesPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(className = "dcp-loading-spinner")
  private WebElement loadingSpinner;

  @FindBy(tagName = "option")
  private WebElement yourState;

  @FindBy(tagName = "option")
  private List<WebElement> yourStates;

  @FindBy(css = "input[aria-labelledby]")
  private WebElement inputPostalCode;

  @FindBy(css = "button button--accept-all wb-button hydrated")
  private List<WebElement> acceptCookie;

  @FindBy(css = "cmm-cookie-banner__overlay")
  private WebElement acceptCookieFrame;

  @FindBy(xpath = "//*[contains(text(),'Postal Code')]")
  private WebElement postalCode;

  @FindBy(css = "cmm-cookie-banner[settings-id='Kvbnw4-6_']")
  private WebElement shadowFather;

  @FindBy(css = "wb7-button[data-test='handle-accept-all-button']")
  private WebElement shadowButton;

  public void stateClick() {
    Commons.waitForVisibilityElement(yourState);
    yourState.click();
  }

  public void stateScan(String state) {
    for (WebElement option : yourStates) {
      if (option.getText().equals(state)) {
        option.click();
        break;
      }
    }
  }

  public void postalCodeInsert(String postal) throws InterruptedException {
    closeCookieShadowRoot();
    inputPostalCode.click();
    inputPostalCode.sendKeys(postal);
  }

  public void closeCookieShadowRoot() throws InterruptedException {
    shadowFather.getShadowRoot().findElement(By.cssSelector("wb7-button[data-test='handle-accept-all-button']")).click();
  }

}
