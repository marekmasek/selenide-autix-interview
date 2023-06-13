package com.example.autix;

import static com.example.autix.config.SelenideConfig.configSelenide;
import static com.example.autix.config.TestProperties.initTestProperties;
import static com.example.autix.config.WebDriverConfig.initWebDriver;
import static com.example.autix.utils.SoftAssertHelper.clearSoftAssert;
import static com.example.autix.utils.SoftAssertHelper.getSoftAssert;
import static org.testng.ITestResult.FAILURE;

import com.example.autix.listener.TestLogListener;
import com.example.autix.page.base.BlankPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Slf4j
@Listeners(value = {TestLogListener.class})
public abstract class TestBase implements IHookable {

  @BeforeSuite(alwaysRun = true)
  public void initTestData() {
    initTestProperties();
    initWebDriver();
    configSelenide();
  }

  @AfterMethod(alwaysRun = true)
  public void closeDriver() {
    new BlankPage().closeDriver();
  }

  @Override
  public void run(IHookCallBack callBack, ITestResult result) {
    callBack.runTestMethod(result);
    SoftAssert softAssert = getSoftAssert();
    clearSoftAssert();
    try {
      softAssert.assertAll();
    } catch (AssertionError e) {
      result.setThrowable(e);
      result.setStatus(FAILURE);
    }
  }
}
