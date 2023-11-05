package page;

import commons.Commons;
import io.qameta.allure.Step;
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
    @FindBy(xpath = "//*[@class='show']")
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

    @FindBy(xpath = "//ul[@class='dcp-multi-select-dropdown__card dcp-multi-select-dropdown-card dcp-multi-select-dropdown-card--expanded']//descendant::span")
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

    @FindBy(css = "dcp-cars-srp__results dcp-cars-srp-results")
    private WebElement waitHighPriceCarList;

    @FindBy(css = ".dcp-vehicle-details-list-item__label")
    private List<WebElement> listDetailsModel;

    @FindBy(xpath = "//*[contains(text(),'BRILLANTBLUE metallic')]")
    private WebElement metallicButton;

    @FindBy(xpath = "//*[contains(text(),'Body Type')]")
    private WebElement bodyTypeWait;

    @FindBy(xpath = "//*[contains(text(),'Show more vehicles')]")
    private WebElement scrollToMoreCars;

    @Step
    public void selectFilter()  {
        Commons.waitFluentForElementToBeClickable(clickOnFilter);
        clickOnFilter.click();
        Commons.waitForVisibilityElement(preOwnerList.get(0));
        preOwnerList.get(0).click();
    }

    @Step
    public void listMenuFilter(String menu) {
        for (WebElement filter : listMenuSeletion) {
            if (filter.getText().equals(menu)) {
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
                Commons.scrollToElement(colours);
                colours.click();
                break;
            }
        }
    }

    @Step
    public void selectAndChooseColour () {
        selectFilter();
        Commons.scrollToElement(scrollToMoreCars);
        listMenuFilter("Colour");
        Commons.scrollDown();
        Commons.scrollToElement(openColourFilter);
        openColourFilter.click();
        selectColourTry();
    }
    @Step
    public void selectFilterCar() {
        Commons.waitForVisibilityElement(openFilterCar);
        openFilterCar.click();
        openHighPrices.click();
    }

    @Step
    public void clickHighPriceCar() {
        try {
            Commons.waitFluentForElementToBeClickable(openListCars.get(0));
            openListCars.get(0).click();
        } catch (Exception e){
            System.out.println("Error click high price car.");
        }
    }

    @Step
    public void selectCarAndPriceFilter(){
        selectFilterCar();
        clickHighPriceCar();
    }

    @Step
    public void selectColourTry() {
        try {
            Commons.scrollDown();
            Commons.scrollToElement(metallicButton);
            metallicButton.click();
        } catch (Exception e) {
            System.out.println("Error select colour");
        }

    }
}