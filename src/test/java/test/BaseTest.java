package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import page.MercedeContactDetailsPage;
import page.MercedesCarDetailsPage;
import page.MercedesFilterPage;
import page.MercedesPage;

public class BaseTest extends DriverManager {

  MercedesPage mercedesPage;
  MercedesFilterPage mercedesFilterPage;
  MercedesCarDetailsPage mercedesCarDetailsPage;
  MercedeContactDetailsPage mercedeContactDetailsPage;

  @BeforeEach
  public void set() {
    mercedesPage = new MercedesPage(driver);
    mercedesFilterPage = new MercedesFilterPage(driver);
    mercedesCarDetailsPage = new MercedesCarDetailsPage(driver);
    mercedeContactDetailsPage = new MercedeContactDetailsPage(driver);
  }

}