package page;

import commons.Commons;
import io.qameta.allure.Step;
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

  @FindBy(xpath = "//button[@data-test-id='state-selected-modal__close']")
  private WebElement continueButtonXpath;

  @FindBy(css = ".show > path")
  private WebElement clickOnFilter;

  @FindBy(css = ".dcp-filter-wrapper:nth-child(7) .category-filter-row-headline")
  private WebElement clickOnColour;

  @FindBy(css = "button[class='wb-button wb-button--tertiary wb-button--medium']")
  private List<WebElement> preOwnerList;

  @FindBy(css = ".category-filter-row-headline__text")
  private List<WebElement> menuFilterList;

  @FindBy(css = ".dcp-filter-wrapper:nth-child(7) .dcp-multi-select-dropdown__frame")
  private WebElement openColourFilter;

  @FindBy(linkText = "BRILLANTBLUE metallic")
  private WebElement colourSelect;

  @FindBy(xpath = "//*[contains(text(),'Relevance')]")
  private WebElement openFilterCar;

  @FindBy(css = "select")
  private List<WebElement> openFilterCarList;

  @FindBy(xpath = "//option[@value='price-desc-ucos']")
  private WebElement openHighPrices;

  @FindBy(xpath = "//*[@class='dcp-cars-srp-results__tile']")
  private List<WebElement> openListCars;

  @FindBy(css = ".dcp-vehicle-details-list-item__label")
  private List<WebElement> listDetailsModel;


  @Step
  public void stateClick() {
    Commons.waitForInvisibilityElement(loadingSpinner);
    Commons.waitForVisibilityElement(yourState);
    yourState.click();
  }

  @Step
  public void stateScan(String state) {
    for (WebElement option : yourStates) {
      if (option.getText().equals(state)) {
        option.click();
        break;
      }
    }
  }

  @Step
  public void selectionState(String state){
    stateClick();
    stateScan(state);
  }

  @Step
  public void closeCookieShadowRoot() {
    shadowFather.getShadowRoot().findElement(By.cssSelector("wb7-button[data-test='handle-accept-all-button']")).click();
  }

  @Step
  public void postalCodeInsert(String postal) {
    closeCookieShadowRoot();
    inputPostalCode.click();
    inputPostalCode.sendKeys(postal);
    selectPrivate();
    selectContinue();
  }

  @Step
  public void selectPrivate() {
    Commons.waitForElementToBeClickable(privateButton);
    privateButton.click();
  }

  @Step
  public void selectContinue() {
    Commons.waitFluentForElementToBeClickable(continueButtonXpath);
    continueButtonXpath.click();
  }

}