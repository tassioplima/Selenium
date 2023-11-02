package page;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercedesPage extends PagesFactory {
    private WebDriver driver;

    public  MercedesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "qvbr754xn")
    private WebElement yourState;

    public void action(){
        yourState.click();
    }

}