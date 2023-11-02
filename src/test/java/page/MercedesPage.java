package page;

import commons.Commons;
import driver.DriverManager;
import io.github.sukgu.Shadow;
import io.github.sukgu.support.FindElementBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.List;
import java.util.Locale;

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

    public void waitForTheCookie(){
            Commons.waitForElementToBeClickable(acceptCookieFrame);
            driver.switchTo().frame(acceptCookieFrame);
            driver.switchTo().frame(acceptCookie.get(0));
            Commons.waitForVisibilityElement(acceptCookie.get(0));
            acceptCookie.get(0).click();
    }

    public void closeCookieShadowRoot() throws InterruptedException {
            Thread.sleep(30000);
            WebElement shadowHost = driver.findElement(By.cssSelector("cmm-cookie-banner[settings-id]"));
            System.out.println(shadowHost.getText());
            //SearchContext shadowRoot = shadowHost.getShadowRoot();
          //  shadowRoot.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > cmm-buttons-wrapper:nth-child(3) > div:nth-child(1) > div:nth-child(1) > wb7-button:nth-child(2)")).getShadowRoot()
           //         .findElement(By.cssSelector(".button")).click();

    }

    public void clickShadowDOMButton() throws InterruptedException {
        Shadow shadow = new Shadow(driver);
        shadow.setImplicitWait(30);
        WebElement element = shadow.findElementByXPath("//*[@id=\"app\"]/div[1]/cmm-cookie-banner//div/div/div[2]/cmm-buttons-wrapper/div/div/wb7-button[2]");
        element.click();
        System.out.println(element.getText());
    }



    public void postalCodeInsert(String postal) throws InterruptedException {
        clickShadowDOMButton();
        Commons.waitForVisibilityElement(postalCode);
        postalCode.click();
        postalCode.sendKeys(postal);
    }

}