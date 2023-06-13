package com.example.autix.utils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class ParamXpath {

  private final String xpath;
  private String as;

  public ParamXpath(String xpath) {
    this.xpath = xpath;
  }

  public By getByXpath(Object... xpathParams) {
    return By.xpath(format(xpath, xpathParams));
  }

  public SelenideElement getElementByXpath(Object... xpathParams) {
    var element = $(getByXpath(xpathParams));
    if (StringUtils.isNotBlank(as)) {
      element = element.as(as + " - " + Arrays.toString(xpathParams));
    }
    return element;
  }

  public ParamXpath as(String s) {
    as = s;
    return this;
  }

  public String getXpathString(Object... xpathParams) {
    return format(xpath, xpathParams);
  }

  public ParamXpath join(ParamXpath... paramXpaths) {
    return paramXpath(
        this.toString() + Stream.of(paramXpaths).map(ParamXpath::toString).collect(Collectors.joining("")));
  }

  public ParamXpath join(String... xpaths) {
    return paramXpath(this.toString() + String.join("", xpaths));
  }

  @Override
  public String toString() {
    return xpath;
  }

  public static ParamXpath paramXpath(String paramXpath) {
    return new ParamXpath(paramXpath);
  }

  public static SelenideElement paramXpath(String paramXpath, Object... xpathParams) {
    return $x(format(paramXpath, xpathParams));
  }
}