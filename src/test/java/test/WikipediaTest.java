package test;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class WikipediaTest extends BaseTest {

  @Test
  @Description("Search some information")
  public void testWikipedia() {
      wikipediaPage.search("Pokemon");
  }

}