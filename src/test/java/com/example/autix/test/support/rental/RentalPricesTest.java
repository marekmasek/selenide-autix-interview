package com.example.autix.test.support.rental;

import static com.codeborne.selenide.Selenide.open;

import com.example.autix.TestBase;
import com.example.autix.page.support.RentalPricesPage;
import org.testng.annotations.Test;

public class RentalPricesTest extends TestBase {

   /*
      4 ) na článku o „půjčovném“ v "Centrum pomoci" https://help.autix.eu/cs/article/ceniky-pujcovneho -> spočítat počet obrázku na stránce,
          ověřit že jich je správný počet, a udělat snapshot test, který vizuálně porovná, že nedošlo ke změně na stránce
   */

  @Test(description = "Rental prices article snapshot")
  public void rentalPrices() {
    open(RentalPricesPage.URL);

    new RentalPricesPage()
        .countImages(5)
        .compareSnapshotImage();
  }

  /**
   * Run this method to update expected snapshot image
   */
  @Test(enabled = false)
  public void updateSnapshotImage() {
    open(RentalPricesPage.URL);

    new RentalPricesPage().updateSnapshotImage();
  }

}
