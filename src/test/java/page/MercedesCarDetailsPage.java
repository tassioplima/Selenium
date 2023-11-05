package page;

import commons.Commons;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MercedesCarDetailsPage extends PagesFactory{

    public String vinNumber;
    public String modelYear;
    public MercedesCarDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='dcp-vehicle-details-list-item__label']")
    private List<WebElement> getListDetails;

    @FindBy(xpath = "//*[@class='dcp-vehicle-details-list-item__value']")
    private List<WebElement> getlistValueDetails;

    @FindBy(xpath = "//*[@data-test-id='dcp-buy-box__contact-seller']")
    private WebElement enquireNow;


    @Step
    public void returnListDetailsModel() {

        int index = 0;

        for (WebElement details : getListDetails) {
            if (details.getText().equals("Model Year")) {
                getlistValueDetails.get(index).getText();
                break;
            }
            index++;
        }
        modelYear = getlistValueDetails.get(index).getText();
    }

    @Step
    public void returnListDetailsVinNumber() {

        int index = 0;

        for (WebElement details : getListDetails) {
            if (details.getText().equals("VIN")) {
                getlistValueDetails.get(index).getText();
                break;
            }
            index++;
        }
        vinNumber = getlistValueDetails.get(index).getText();
    }

    @Step
    public void clickEnquireNow() {
        Commons.scrollToElement(enquireNow);
        enquireNow.click();
    }

    @Step
    public void detailsAndExport() {
        Commons.scrollDown();
        returnListDetailsModel();
        Commons.scrollDown();
        returnListDetailsVinNumber();
        Commons.exportFileString( "Model year: " + modelYear,"VIN: " +  vinNumber);
        clickEnquireNow();
    }

}