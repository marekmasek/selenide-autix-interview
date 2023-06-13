package com.example.autix.page.support;

import static com.codeborne.selenide.Selenide.$x;
import static com.example.autix.config.TestProperties.getSupportUrl;

import com.codeborne.selenide.SelenideElement;
import com.example.autix.page.HomePage;
import com.example.autix.page.base.MasterPage;

public class SupportPage extends MasterPage {

  public static final String URL = getSupportUrl();

  private static final SelenideElement CAR_RENTAL_BTN = $x("//h2[.='Autopůjčovna']").as("Car Rental button");
  private static final SelenideElement BACK_TO_APP_BTN = $x(
      "//div[contains(@class,'max-w-[90rem]')]//a[contains(@href,'autix.eu')]").as("Back to APP button");

  public SupportArticleMenu clickCarRentalBtn() {
    CAR_RENTAL_BTN.click();
    return new SupportArticleMenu();
  }

  public HomePage clickBackToAppBtn() {
    BACK_TO_APP_BTN.click();
    return new HomePage();
  }

}
