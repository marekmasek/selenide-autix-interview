package com.example.autix.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.example.autix.listener.DriverListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;

@Log4j2
public class WebDriverConfig {

  public static void initWebDriver() {
    Configuration.fastSetValue = true; // Should speed up entering text
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    setChromeSpecificOptions();

    WebDriverRunner.addListener(new DriverListener());
  }

  private static void setChromeSpecificOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
    options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
    options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
    options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
    options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
    options.addArguments(
        "--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
    options.addArguments(
        "--disable-backgrounding-occluded-windows"); //https://www.bleepingcomputer.com/news/software/google-fixes-white-screen-problem-in-chrome-admins-furious/
    options.addArguments(
        "--disable-site-isolation-trials"); //https://stackoverflow.com/questions/55722476/selenium-switchto-return-error-org-openqa-selenium-webdriverexception-unknown-e
    Configuration.browserCapabilities.merge(options);
  }

}
