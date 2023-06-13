package com.example.autix.exception;

import static java.lang.String.format;

public class FileUtilsException extends RuntimeException {

  public FileUtilsException(final String message, final Object... messageParams) {
    super(format(message, messageParams));
  }

}
