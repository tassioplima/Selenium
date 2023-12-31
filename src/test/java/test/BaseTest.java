package test;

import driver.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import page.WikipediaPage;

public class BaseTest extends DriverManager {

  WikipediaPage wikipediaPage;

  @BeforeEach
  public void set() {
    wikipediaPage = new WikipediaPage(driver);

  }

}