package com.example.autix.config;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SelenideConfig {

  public static void configSelenide() {
    Configuration.timeout = 15000L;
    Configuration.baseUrl = TestProperties.getBaseUrl();
    Configuration.pageLoadStrategy = "normal";
  }
}
