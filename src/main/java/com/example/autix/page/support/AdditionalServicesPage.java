package com.example.autix.page.support;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.example.autix.page.base.MasterPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AdditionalServicesPage extends MasterPage {


  private static final SelenideElement ADDITIONAL_SERVICES_HDR = $x("//h1[.='Doplňkové služby']").as(
      "Additional Services Header");

  public void additionalServicesHeaderShouldBeVisible() {
    log.info("Checking if Additional Services header is visible");
    ADDITIONAL_SERVICES_HDR.shouldBe(Condition.visible);
  }

}
