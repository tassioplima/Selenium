package page;

import commons.Commons;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MercedeContactDetailsPage extends PagesFactory{

    public MercedeContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "dcp-loading-spinner")
    private WebElement loadingSpinner;
    @FindBy(xpath = "//*[@inputmode='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@name='checkmark-xs']")
    private List<WebElement> checkBoxList;

    @FindBy(xpath = "//*[@data-test-id='dcp-rfq-contact-button-container__button-next']")
    private WebElement proceedButton;

    @FindBy(xpath = "//*[@class='dcp-error-message__error-hint']")
    private WebElement errorLabel;

    @FindBy(xpath = "//*[contains(text(),'Contact Details and Account Creation')]")
    private WebElement waitForm;

    @Step
    public void insertInvalidEmail(String email) {
        Commons.waitForInvisibilityElement(loadingSpinner);
        emailField.sendKeys(email);
    }

    @Step
    public void proceedAndPrivacy() {
        Commons.scrollToElement(checkBoxList.get(0));
        checkBoxList.get(0).click();
        Commons.scrollToElement(proceedButton);
        proceedButton.click();
    }

    @Step
    public void validateError() {
        Commons.scrollToElement(errorLabel);
        String assertion = errorLabel.getText();
        assertEquals("An error has occurred.\n" +
                "Please check the following sections:", assertion);
    }

    @Step
    public void insertDataAndValidateError (String email) {
        insertInvalidEmail(email);
        proceedAndPrivacy();
        validateError();
    }
}