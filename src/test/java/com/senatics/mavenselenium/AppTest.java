/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senatics.mavenselenium;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class AppTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

@Before
  public void setUp() throws Exception {
    //System.setProperty("webdriver.chrome.driver", "mavenproject1/drivers/chromedriver.exe");
    //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    //System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
    //System.setProperty("webdriver.gecko.driver", "mavenproject1/drivers/geckodriver.exe");   
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
  }

  @Test
  public void testregistrarClientes() throws Exception {
    Thread.sleep (700);
    baseUrl = "https://www.winrar.es/";
    driver.get(baseUrl + "/?PHPSESSID=bep75et8m4tmkg4ork94uk7ubks48vbk");
    driver.findElement(By.linkText("Noticias")).click();
    driver.findElement(By.linkText("Premios")).click();
    driver.findElement(By.linkText("Notas de prensa")).click();
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
/**/
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
