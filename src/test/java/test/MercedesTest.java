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
    public void testMercedes() throws InterruptedException {
        mercedesPage.stateClick();
        mercedesPage.stateScan("New South Wales");
        mercedesPage.postalCodeInsert("2007");
    }
}
