package com.example.autix.exception;

import static java.lang.String.format;

public class ScreenshotUtilsException extends RuntimeException {

  public ScreenshotUtilsException(final String message, final Exception e, final Object... messageParams) {
    super(format(message, messageParams), e);
  }

}
