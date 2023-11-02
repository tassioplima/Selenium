package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MercedesPage;

public class MercedesTest extends DriverManager {

    MercedesPage mercedesPage;

    @BeforeEach
    public void set(){
        mercedesPage = new MercedesPage(driver);
    }
    @Test
    public void testMercedes() {
        mercedesPage.action();
    }
}
