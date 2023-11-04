package page;

import commons.Commons;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MercedesFilterPage extends PagesFactory {

    public MercedesFilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "dcp-loading-spinner")
    private WebElement loadingSpinner;
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

    @FindBy(xpath = " //*[@class='dcp-filter-wrapper']")
    private List<WebElement> listMenuFilter;

    @FindBy(linkText = "BRILLANTBLUE metallic")
    private WebElement colourSelect;

    @FindBy(xpath = "//*[@class='dcp-filter-pill__status dcp-filter-pill-status']")
    private List<WebElement> listColourSelect;

    @FindBy(xpath = "//*[@class='category-filter-row-headline__text']")
    private List<WebElement> listMenuSeletion;

    @FindBy(xpath = "//*[@class='category-filter-row-headline active']")
    private WebElement clickMenuColour;

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
    public void selectFilter()  {
        Commons.waitForElementToBeClickable(clickOnFilter);
        clickOnFilter.click();
        Commons.waitForVisibilityElement(preOwnerList.get(0));
        preOwnerList.get(0).click();
    }

    @Step
    public void listMenuFilter(String menu) {
        for (WebElement filter : listMenuSeletion) {
            if (filter.getText().equals(menu)) {
                Commons.waitForVisibilityElement(filter);
                Commons.scrollToElement(filter);
                filter.click();
                break;
            }
        }
    }
    @Step
    public void selectFilterColourList(String colour) {
        for (WebElement colours : listColourSelect) {
            if (colours.getText().equals(colour)) {
                System.out.println(colours.getText());
                colours.click();
                break;
            }
        }
    }

    @Step
    public void selectAndChooseColour (String colour) {
        selectFilter();
        Commons.waitForInvisibilityElement(loadingSpinner);
        listMenuFilter("Colour");
        Commons.scrollToElement(openColourFilter);
        openColourFilter.click();
        Commons.scrollToElement(colourSelect);
        Commons.waitForVisibilityElement(driver.findElement(By.linkText(colour)));
        driver.findElement(By.linkText(colour)).click();
    }
    @Step
    public void selectFilterCar() {
        Commons.waitForVisibilityElement(openFilterCar);
        openFilterCar.click();
        openHighPrices.click();
    }

    @Step
    public void getHighPriceCarDetails() {
        openListCars.get(0).click();
    }

    @Step
    public void selectCarAndPriceFilter(){
        selectFilterCar();
        getHighPriceCarDetails();
    }
}