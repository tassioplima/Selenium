package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MercedesPage;

public class MercedesTest extends DriverManager {

    MercedesPage mercedesPage;
    @Test
    public void testMercedes() {
        mercedesPage = new MercedesPage(driver);
        mercedesPage.action();

    }
}
