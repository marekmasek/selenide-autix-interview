package com.example.autix.test;

import static com.codeborne.selenide.Selenide.open;
import static com.example.autix.enums.Localization.CS;
import static com.example.autix.enums.Localization.EN;

import com.example.autix.TestBase;
import com.example.autix.enums.Localization;
import com.example.autix.page.HomePage;
import com.example.autix.page.NavigationMenu;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

  /*
      1) přepnutí jazyka z EN na CZ a kontrola, že je text na webu v požadovaném jazyku (kontrola obsahu stránky)
   */

  @Test(dataProvider = "getTestData", description = "Switch localization EN to CS on Home page")
  public void switchLocalization(Localization fromLocalization, Localization toLocalization) {
    open(HomePage.URL + (EN.equals(fromLocalization) ? "" : fromLocalization.getIsoCode()));

    new NavigationMenu().switchLanguage(toLocalization);
    new HomePage().checkLanguage(toLocalization);
  }

  @DataProvider
  private Object[][] getTestData() {
    return new Object[][]{
        //{fromLocalization, toLocalization}
        {EN, CS},
        {CS, EN}
    };
  }

}
