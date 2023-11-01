package page;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercedesPage extends DriverManager {
    private WebDriver driver;

    public  MercedesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "dcp-loading-spinner__spinner dcp-loading-spinner__spinner--dark")
    private WebElement loading;

    @FindBy(id = "qvbr754xn")
    private WebElement yourState;

    public void action(){
        loading.getLocation();
        yourState.click();
    }

}