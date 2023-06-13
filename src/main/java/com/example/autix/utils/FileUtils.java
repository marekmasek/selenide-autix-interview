package com.example.autix.utils;

import com.example.autix.exception.FileUtilsException;
import java.io.InputStream;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class FileUtils {

  public static InputStream getFileFromResourceAsStream(String fileName) {
    ClassLoader classLoader = FileUtils.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);

    if (inputStream == null) {
      throw new FileUtilsException("File not found! " + fileName);
    } else {
      return inputStream;
    }
  }
}
