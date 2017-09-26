/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senatics.mavenselenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AppTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

@Before
  public void setUp() throws Exception {
    //System.setProperty("webdriver.chrome.driver", "mavenproject1/drivers/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
  }

  @Test
  public void testregistrarClientes() throws Exception {
     
    baseUrl = "http://10.0.20.7:8083";
    driver.get(baseUrl + "/WebPruebaSenatics");   
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("aramirez");    
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("1234");
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.linkText("Agregar Cliente")).click();
    driver.findElement(By.id("citext")).clear();
    driver.findElement(By.id("citext")).sendKeys("5555444");
    driver.findElement(By.id("nombretext")).clear();
    driver.findElement(By.id("nombretext")).sendKeys("Justo Almada");
    driver.findElement(By.name("guardar")).click();
    driver.findElement(By.linkText("Agregar Cliente")).click();
    driver.findElement(By.id("citext")).clear();
    driver.findElement(By.id("citext")).sendKeys("44455544");
    driver.findElement(By.id("nombretext")).clear();
    driver.findElement(By.id("nombretext")).sendKeys("Juan Sosa");
    driver.findElement(By.name("guardar")).click();
    driver.findElement(By.cssSelector("button[name=\"cerrarSesion\"]")).click();
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
