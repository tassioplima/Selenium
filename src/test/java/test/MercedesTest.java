package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MercedesPage;

public class MercedesTest extends DriverManager {

    public MercedesPage mercedesPage;

   @BeforeEach()
   public void setup(){
       mercedesPage = new MercedesPage(driver);
   }
    @Test
    public void testMercedes() {
        mercedesPage.action();
    }
}
