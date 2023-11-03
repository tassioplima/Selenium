package page;

import commons.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

  @FindBy(css = ".wb-margin-bottom-xs:nth-child(1) .wb-radio-control__indicator")
  private WebElement privateButton;

  @FindBy(css = ".wb-margin-bottom-xs:nth-child(2) .wb-radio-control__indicator")
  private WebElement businessButton;

  @FindBy(css = "input[type=radio]")
  private List<WebElement> listPrivateBusiness;

  @FindBy(css = ".dcp-state-selected-modal__close")
  private WebElement continueButton;

  public void stateClick() {
    Commons.waitForInvisibilityElement(loadingSpinner);
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

  public void closeCookieShadowRoot() throws InterruptedException {
    shadowFather.getShadowRoot().findElement(By.cssSelector("wb7-button[data-test='handle-accept-all-button']")).click();
  }

  public void postalCodeInsert(String postal) throws InterruptedException {
    closeCookieShadowRoot();
    inputPostalCode.click();
    inputPostalCode.sendKeys(postal);
  }

  public void selectPrivate() {
    privateButton.click();
  }

  public void selectContinue(){
    continueButton.click();
  }

  public void selectPrivateAndContinue(){
    selectPrivate();
    selectContinue();
  }



}
