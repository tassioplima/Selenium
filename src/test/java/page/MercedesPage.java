package page;

import commons.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MercedesPage extends PagesFactory {
    private WebDriver driver;

    public  MercedesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "dcp-loading-spinner")
    private WebElement loadingSpinner;
    @FindBy(tagName = "option")
    private WebElement yourState;
    @FindBy(tagName = "option")
    private List<WebElement> yourStates;

    @FindBy(css = "button button--accept-all wb-button hydrated")
    private List<WebElement> acceptCookie;

    @FindBy(css = "cmm-cookie-banner__overlay")
    private WebElement acceptCookieFrame;

    @FindBy(xpath = "//*[contains(text(),'Postal Code')]")
    private WebElement postalCode;

    @FindBy(css = "cmm-cookie-banner")
    private WebElement shadowApp;

    @FindBy(css = "cmm-cookie-banner[class='hydrated']")
    private WebElement shadowApp2;

    @FindBy(css = " div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > cmm-buttons-wrapper:nth-child(3) > div:nth-child(1) > div:nth-child(1) > wb7-button:nth-child(2)")
    private WebElement shadowApp3;


    public void stateClick(){
       //Commons.waitForInvisibilityElement(loadingSpinner);
        Commons.waitForVisibilityElement(yourState);
        yourState.click();
    }

    public void stateScan(String state){
        for (WebElement option : yourStates) {
            if (option.getText().equals(state)) {
                option.click();
                break;
            }
        }

    }

    public void postalCodeInsert(String postal) throws InterruptedException {
        closeCookieShadowRoot();
        Commons.waitForVisibilityElement(postalCode);
        postalCode.click();
        postalCode.sendKeys(postal);
    }

    public void closeCookieShadowRoot() throws InterruptedException {
        //SearchContext shadowFirst = shadowApp2.getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow0 = shadowApp2.getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > cmm-buttons-wrapper:nth-child(3) > div:nth-child(1) > div:nth-child(1) > wb7-button:nth-child(2)")).getShadowRoot();
        WebElement shadow3  = shadow1.findElement(By.cssSelector(" button"));
        System.out.println(shadow3.getText());

        // WebElement shadow3 = shadow2.findElement(By.cssSelector(" button:nth-child(1) > slot:nth-child(1)"));
    }

}