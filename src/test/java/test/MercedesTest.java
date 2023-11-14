package test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class MercedesTest extends BaseTest {

  @Test
  @Description("Validate error on Mercedes form.")
  public void testMercedes() {
    mercedesPage.selectionState("New South Wales");
    mercedesPage.postalCodeInsert("2007");
    mercedesFilterPage.selectAndChooseColour();
    mercedesFilterPage.selectCarAndPriceFilter();
    mercedesCarDetailsPage.detailsAndExport();
    mercedeContactDetailsPage.insertDataAndValidateError("tassio.com");
  }

}