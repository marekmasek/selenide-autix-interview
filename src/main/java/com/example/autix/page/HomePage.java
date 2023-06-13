package com.example.autix.page;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.example.autix.config.TestProperties.getBaseUrl;
import static com.example.autix.enums.Localization.EN;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.autix.config.TestProperties;
import com.example.autix.enums.Localization;
import com.example.autix.page.base.MasterPage;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HomePage extends MasterPage {

  public static final String URL = getBaseUrl();

  private static final SelenideElement HTML = $x("//html").as("HTML element");
  private static final ElementsCollection TEXT_BLOCK_ELEMENTS = $$x("//div[contains(@id,'text_block')]").as("Text block elements");

  private static final List<String> TEXTS_EN = List.of(
      "Autix BMS is a modern and comprehensive online system",
      "Employee control and loss minimisation",
      "New car sales agenda and agenda for the sale of used cars in simple way",
      "What are the main differences between off-line and on-line solutions"
  );

  private static final List<String> TEXTS_CZ = List.of(
      "Autix BMS je moderní a komplexní online systém",
      "Kontrola zaměstnanců a minimalizace ztrát",
      "Agenda prodeje nových vozů a agenda prodeje ojetých vozů jednoduchým způsobem",
      "Jaké jsou hlavní rozdíly mezi off-line a on-line řešeními"
  );

  public HomePage checkLanguage(Localization localization) {
    log.info("Checking language of the page");
    HTML.shouldHave(attribute("lang", localization.getHtmlLang()));

    List<String> expectedTexts = switch (localization) {
      case CS -> TEXTS_CZ;
      case EN -> TEXTS_EN;
      default -> throw new IllegalStateException("Expected texts are not implemented for this localization, they have to be added");
    };

    TEXT_BLOCK_ELEMENTS.shouldHave(CollectionCondition.containExactTextsCaseSensitive(expectedTexts));
    return this;
  }

  public HomePage verifyUrl(Localization localization) {
    log.info("Checking that url is matching the expected localization: " + localization.name());
    String expectedUrl = getBaseUrl();
    expectedUrl = EN.equals(localization) ? expectedUrl : expectedUrl + localization.getIsoCode();
    webdriver().shouldHave(url(expectedUrl));
    return this;
  }
}
