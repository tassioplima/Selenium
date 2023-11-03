package page;

import commons.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MercedesPage extends PagesFactory {
  private WebDriver driver;
  public String vimNumber;
  public String modelYear;

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

  @FindBy(css = "dcp-cars-srp__sorting-dropdown hydrated")
  private WebElement openFilterCar;

  @FindBy(css = "select")
  private List<WebElement> openFilterCarList;

  @FindBy(css = "[value='price-desc-ucos']")
  private WebElement openHighPrices;

  @FindBy(css = ".dcp-cars-srp-results__tile")
  private List<WebElement> openListCars;

  @FindBy(css = ".dcp-vehicle-details-list-item__label")
  private List<WebElement> listDetailsModel;


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

  public void selectionState(String state){
    stateClick();
    stateScan(state);
  }

  public void closeCookieShadowRoot() {
    shadowFather.getShadowRoot().findElement(By.cssSelector("wb7-button[data-test='handle-accept-all-button']")).click();
  }

  public void postalCodeInsert(String postal) {
    closeCookieShadowRoot();
    inputPostalCode.click();
    inputPostalCode.sendKeys(postal);
  }

  public void selectPrivate() {
    privateButton.click();
  }

  public void selectContinue(){
    Commons.waitForElementToBeClickable(continueButton);
    continueButton.click();
    //Commons.waitForInvisibilityElement(continueButton);
  }

  public void selectPrivateAndContinue(){
    selectPrivate();
    selectContinue();
  }

  public void selectFilter()  {
    Commons.waitForElementToBeClickable(clickOnFilter);
    clickOnFilter.click();
    Commons.waitForVisibilityElement(preOwnerList.get(0));
    preOwnerList.get(0).click();
  }

  public void selectAndChooseColor (String colour) throws InterruptedException {
    selectFilter();
    Commons.waitForInvisibilityElement(loadingSpinner);
    Commons.scrollDown();
    Commons.moveToElementByWebElement(menuFilterList.get(6));
    menuFilterList.get(6).click();
    Commons.scrollDown();
    openColourFilter.click();
    colourSelect.click();
  }

  public void selectFilterCar() {
    Commons.waitForVisibilityElement(openFilterCar);
    openFilterCar.click();
    openHighPrices.click();
  }

  public void getHighPriceCarDetails() {
    openListCars.get(0).click();

    for (WebElement option : listDetailsModel) {
      if (option.getText().equals("Model Year")) {
        String modelYear = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].childNodes[2].textContent;", option);
        break;
      }
      System.out.println(modelYear);
    }

  }


}
