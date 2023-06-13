package com.example.autix.page.support;

import static com.codeborne.selenide.Selenide.$x;
import static com.example.autix.config.TestProperties.getSupportUrl;
import static com.example.autix.utils.ScreenshotUtils.expectPageToHaveScreenshot;
import static com.example.autix.utils.ScreenshotUtils.takeElementScreenshot;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.autix.page.base.MasterPage;
import java.io.File;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RentalPricesPage extends MasterPage {

  public static final String URL = getSupportUrl() + "cs/article/ceniky-pujcovneho";

  private static final SelenideElement RENTAL_PRICES_HDR = $x("//h1[.='Ceníky půjčovného']").as("Rental Prices Header");
  private static final SelenideElement ARTICLE = $x("//div[contains(@class,'ck-content')]").as("Article element");
  private static final ElementsCollection ARTICLE_IMGS = ARTICLE.$$x(".//img").as("Article Images");

  public RentalPricesPage() {
    RENTAL_PRICES_HDR.shouldBe(Condition.visible);
  }

  public RentalPricesPage countImages(int expectedNumber) {
    log.info("Checking if number of images in article is equal to: " + expectedNumber);
    ARTICLE_IMGS.shouldHave(CollectionCondition.size(expectedNumber));
    return this;
  }

  public void updateSnapshotImage() {
    log.info("Updating snapshot image for Rental Prices article");
    takeElementScreenshot(ARTICLE, new File("src/main/resources/snapshot/rental-prices-expected.png"));//todo use input stream instead
  }

  public void compareSnapshotImage() {
    log.info("Comparing Rental Prices article with expected snapshot");
    File file = new File("src/main/resources/snapshot/rental-prices-actual.png"); //todo use input stream instead
    expectPageToHaveScreenshot(ARTICLE, takeElementScreenshot(ARTICLE, file));
  }

}
