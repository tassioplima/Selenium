package page;

import driver.DriverManager;
import io.github.sukgu.support.ElementFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PagesFactory extends DriverManager{

    protected PagesFactory(WebDriver driver) {
        ElementFieldDecorator decorator = new ElementFieldDecorator(new DefaultElementLocatorFactory(driver));
        PageFactory.initElements(decorator, this);
    }
}