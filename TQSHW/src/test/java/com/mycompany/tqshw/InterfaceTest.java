package com.mycompany.tqshw;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterfaceTest {
  private WebDriver driver;
  private String baseUrl;
  private final boolean acceptNextAlert = true;
  private final StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:/Users/danie/Downloads/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    System.out.println("--Interface Testing My API--");
    driver.get("http://localhost:8080/TQSHW/index.html");
    driver.findElement(By.name("from")).clear();
    driver.findElement(By.name("from")).sendKeys("USD");
    driver.findElement(By.name("amount")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("10");
    driver.findElement(By.name("to")).click();
    driver.findElement(By.name("to")).clear();
    driver.findElement(By.name("to")).sendKeys("EUR");
    driver.findElement(By.id("btn")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}

