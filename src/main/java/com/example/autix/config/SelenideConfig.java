package com.example.autix.config;

import com.codeborne.selenide.Configuration;
import java.util.TimeZone;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SelenideConfig {

  public static void configSelenide() {
    TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("selenide.play.timeZone", "EDT")));
    Configuration.timeout = 30000L;
    Configuration.baseUrl = TestProperties.getBaseUrl();
    Configuration.pageLoadStrategy = "normal";
  }
}
