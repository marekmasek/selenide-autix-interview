package com.example.autix.page;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.example.autix.utils.ParamXpath.paramXpath;

import com.codeborne.selenide.SelenideElement;
import com.example.autix.enums.Localization;
import com.example.autix.page.base.MasterPage;
import com.example.autix.utils.ParamXpath;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class NavigationMenu extends MasterPage {

  private static final SelenideElement LANGUAGE_SWITCHER = $x("//div[contains(@class,'trp-language-switcher')]").as(
      "Language switcher");
  private static final ParamXpath LANGUAGE = paramXpath("//a[contains(@title,'%s')]").as("Specific Language Link");

  public NavigationMenu switchLanguage(Localization localization) {
    log.info("Switching language to: " + localization.name());
    LANGUAGE_SWITCHER.hover();
    sleep(200);
    LANGUAGE.getElementByXpath(localization.getValue()).click();
    return this;
  }
}
