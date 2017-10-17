package com.senatics.mavenselenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class AppTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //System.setProperty("webdriver.gecko.driver", "mavenproject1/drivers/geckodriver.exe"); 
    //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);
    WebDriver driver = new FirefoxDriver(capabilities);
    //driver = new FirefoxDriver();
    baseUrl = "https://notepad-plus-plus.org/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testWinrarPruebaSelenium() throws Exception {
    Thread.sleep (700);
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Download")).click();
    driver.findElement(By.linkText("v7.3.3")).click();
    driver.findElement(By.linkText("News")).click();
    driver.findElement(By.linkText("Features")).click();
  }

//  @After
//  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
//  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
