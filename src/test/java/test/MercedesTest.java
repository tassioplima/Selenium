package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MercedeContactDetailsPage;
import page.MercedesCarDetailsPage;
import page.MercedesFilterPage;
import page.MercedesPage;

public class MercedesTest extends DriverManager {

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

  @Test
  public void testMercedes() {
    mercedesPage.selectionState("New South Wales");
    mercedesPage.postalCodeInsert("2007");
    mercedesFilterPage.selectAndChooseColour();
    mercedesFilterPage.selectCarAndPriceFilter();
    mercedesCarDetailsPage.detailsAndExport();
    mercedeContactDetailsPage.insertDataAndValidateError("tassio.com");
  }

}