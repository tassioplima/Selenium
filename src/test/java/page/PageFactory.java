package page;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageFactory {

    private WebDriver driver;
    protected PageFactory(WebDriver driver) {
        this.driver = driver;
        //initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), 30), this);
    }
}
