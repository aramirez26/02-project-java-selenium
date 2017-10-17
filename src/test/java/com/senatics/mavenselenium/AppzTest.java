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

public class AppzTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //System.setProperty("webdriver.gecko.driver", "mavenproject1/drivers/geckodriver.exe"); 
    //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
    //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//    capabilities.setCapability(FirefoxDriver.MARIONETTE, "hola");
//    WebDriver driver = new FirefoxDriver(capabilities);
    driver = new FirefoxDriver();
    baseUrl = "http://www.chortitzer.com.py/";
    //XvfbRunMojo.ROLE.startsWith(baseUrl);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  
  By createAccount = By.linkText("Create Account");

  @Test
  public void testTrebolPruebaSelenium() throws Exception {
    Thread.sleep (5000);
    driver.get(baseUrl + "/home.php");
    driver.findElement(By.id("industria")).click();
    driver.findElement(By.xpath("//div[@id='area_botonera_interna_derecha']/ul/li[4]/a/div")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

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
