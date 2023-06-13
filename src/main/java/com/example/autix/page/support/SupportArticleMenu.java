package com.example.autix.page.support;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import com.example.autix.page.base.MasterPage;

public class SupportArticleMenu extends MasterPage {

  private static final SelenideElement ADDITIONAL_SERVICES_BTN = $x("//a[.='Doplňkové služby']").as("Additional Services button");

  public AdditionalServicesPage clickAdditionalServicesBtn() {
    ADDITIONAL_SERVICES_BTN.click();
    return new AdditionalServicesPage();
  }

}
