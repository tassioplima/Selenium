package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.MercedesPage;

public class MercedesTest extends DriverManager {

  MercedesPage mercedesPage;

  @BeforeEach
  public void set() {
    mercedesPage = new MercedesPage(driver);
  }

  @Test
  public void testMercedes() throws InterruptedException {
    Thread.sleep(1000);
    driver
        .findElement(By.cssSelector("cmm-cookie-banner[settings-id='Kvbnw4-6_']"))
        .getShadowRoot()
        .findElement(By.cssSelector("wb7-button[data-test='handle-accept-all-button']")).click();

    mercedesPage.stateClick();
    mercedesPage.stateScan("New South Wales");
    mercedesPage.postalCodeInsert("2007");
  }
}
