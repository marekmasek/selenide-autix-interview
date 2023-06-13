package com.example.autix.page.base;

import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public abstract class MasterPage {


  public WebDriver getDriver() {
    return WebDriverRunner.getWebDriver();
  }

  public void closeDriver() {
    try {
      WebDriverRunner.closeWebDriver();
    } catch (Exception e) {
      log.error("Could not close or remove driver because of following error:\n", e);
    }
  }

}
