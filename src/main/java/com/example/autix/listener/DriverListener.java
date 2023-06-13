package com.example.autix.listener;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

@Log4j2
public class DriverListener implements WebDriverListener {

  @Override
  public void beforeClick(WebElement element) {
    log.info("Clicking on element: " + element.getText());
    highlight(element, "red");
  }

  @Override
  public void beforeTo(WebDriver.Navigation navigation, String url) {
    log.info("Navigating to: " + url);
  }

  public static <T extends WebElement> T highlight(T element, final String color) {
    if (element != null && element.getAttribute("__selenideHighlighting") == null) {
      for (int i = 1; i < 4; i++) {
        transform(element, color, i);
        sleep(50);
      }
      for (int i = 4; i > 0; i--) {
        transform(element, color, i);
        sleep(50);
      }
    }
    return element;
  }

  private static void transform(WebElement element, String color, int i) {
    executeJavaScript(
        "arguments[0].setAttribute('__selenideHighlighting', 'done'); " +
            "arguments[0].setAttribute(arguments[1], arguments[2])",
        element,
        "style",
        "border: " + i + "px solid " + color + "; border-style: dashed; " +
            "transform: scale(1, 1." + i + ");");
  }
}