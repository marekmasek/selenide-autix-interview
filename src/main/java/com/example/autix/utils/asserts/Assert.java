package com.example.autix.utils.asserts;

import static java.lang.String.format;
import static org.testng.Assert.fail;

import java.util.List;

public class Assert {

  public static void failTest(boolean isSoftAssert, String errorMessage, Object... args) {
    String assertMessage = format(errorMessage, args);
    if (isSoftAssert) {
      SoftAssertHelper.getSoftAssert().fail(assertMessage);
    } else {
      fail(assertMessage);
    }
  }

  public static <T> void assertListContains(T value, List<T> list) {
    assertListContains(value, list, null);
  }

  public static <T> void assertListContains(T value, List<T> list, String assertMsg) {
    assertMsg = assertMsg == null ? "" : assertMsg + "\n";
    if (!list.contains(value)) {
      fail(format("%sList doesn't contain expected value. %nList: %s %nValue: %s", assertMsg, list, value));
    }
  }

  public static <T> void assertListNotContains(T value, List<T> list) {
    assertListNotContains(value, list, null);
  }

  public static <T> void assertListNotContains(T value, List<T> list, String assertMsg) {
    assertMsg = assertMsg == null ? "" : assertMsg + "\n";
    if (list.contains(value)) {
      fail(format("%sList contains value, which shouldn't be there. %nList: %s %nValue: %s", assertMsg, list, value));
    }
  }
}
