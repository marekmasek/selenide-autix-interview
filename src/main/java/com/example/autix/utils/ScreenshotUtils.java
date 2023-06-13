package com.example.autix.utils;

import static org.testng.Assert.assertFalse;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.example.autix.exception.ScreenshotUtilsException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

@UtilityClass
public class ScreenshotUtils {

  public static File takeElementScreenshot(SelenideElement element, File file) { //todo use inputStream instead
    element.shouldBe(Condition.visible);

    Point point = element.getLocation();
    int eleWidth = element.getSize().getWidth();
    int eleHeight = element.getSize().getHeight();

    try {
      BufferedImage img = ImageIO.read(Objects.requireNonNull(Selenide.screenshot(OutputType.FILE)));
      BufferedImage eleScreenshot = img.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
      ImageIO.write(eleScreenshot, "png", file);
    } catch (IOException e) {
      throw new ScreenshotUtilsException("Cannot save screenshot, because of: ", e);
    }
    return file;
  }

  public static void expectPageToHaveScreenshot(SelenideElement element, File expectedScreenshot) {
    File actualScreenshot = takeElementScreenshot(element, expectedScreenshot);

    try {
      BufferedImage actualImg = ImageIO.read(actualScreenshot);

      ImageDiff imageDiff = new ImageDiffer().makeDiff(ImageIO.read(expectedScreenshot), actualImg);
      assertFalse(imageDiff.hasDiff(), "Compared screenshot is not as expected one, difference size: " + imageDiff.getDiffSize());
    } catch (IOException e) {
      throw new ScreenshotUtilsException("Cannot read screenshot, because of: ", e);
    }
  }

}
