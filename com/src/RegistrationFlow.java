package src;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFlow {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Logger log;

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "geckodriver");
	driver = new FirefoxDriver();
    baseUrl = "https://www.groupon.com";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    log = Logger.getLogger(RegistrationFlow.class);
  }

  @Test
  public void validSignUp() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
    
	driver.get(baseUrl + "/");
    driver.findElement(By.id("nothx")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up"))); 
    
    driver.findElement(By.linkText("Sign Up")).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up"))); 
    
    driver.findElement(By.cssSelector("label.twelve")).click();
    driver.findElement(By.id("full-name-input")).clear();
    driver.findElement(By.id("full-name-input")).sendKeys("abc");
    driver.findElement(By.cssSelector("#field-email-input > label.twelve")).click();
    driver.findElement(By.cssSelector("#field-password-input > label.twelve")).click();
    driver.findElement(By.id("email-input")).clear();
    driver.findElement(By.id("email-input")).sendKeys("p1008066@mvrht.com");
    driver.findElement(By.cssSelector("#field-password-input > label.twelve")).click();
    driver.findElement(By.id("password-input")).clear();
    driver.findElement(By.id("password-input")).sendKeys("passwordabc");
    driver.findElement(By.cssSelector("#field-password-confirmation-input > label.twelve")).click();
    driver.findElement(By.id("terms-checkbox")).click();
    driver.findElement(By.id("remember-me-checkbox")).click();
    driver.findElement(By.id("password-confirmation-input")).clear();
    driver.findElement(By.id("password-confirmation-input")).sendKeys("passwordabc");
    driver.findElement(By.name("submit")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Help")));
    
    try{
	    WebElement we =  driver.findElement(By.className("error"));
	    log.error("Error in sign up process.");
    	
    }catch(NoSuchElementException ne){
    	log.info("Sign up successful.");
    }
  }
  
  @Test
  public void invalidSignUp() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 10);
    
	driver.get(baseUrl + "/");
    driver.findElement(By.id("nothx")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up"))); 
    
    driver.findElement(By.linkText("Sign Up")).sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up"))); 
    
    driver.findElement(By.cssSelector("label.twelve")).click();
    driver.findElement(By.id("full-name-input")).clear();
    driver.findElement(By.id("full-name-input")).sendKeys("");
    driver.findElement(By.cssSelector("#field-email-input > label.twelve")).click();
    driver.findElement(By.cssSelector("#field-password-input > label.twelve")).click();
    driver.findElement(By.id("email-input")).clear();
    driver.findElement(By.id("email-input")).sendKeys("p1008066@mvrht.com");
    driver.findElement(By.cssSelector("#field-password-input > label.twelve")).click();
    driver.findElement(By.id("password-input")).clear();
    driver.findElement(By.id("password-input")).sendKeys("passwordabc");
    driver.findElement(By.cssSelector("#field-password-confirmation-input > label.twelve")).click();
    driver.findElement(By.id("terms-checkbox")).click();
    driver.findElement(By.id("remember-me-checkbox")).click();
    driver.findElement(By.id("password-confirmation-input")).clear();
    driver.findElement(By.id("password-confirmation-input")).sendKeys("passwordabc");
    driver.findElement(By.name("submit")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Help")));
    
    try{
	    WebElement we =  driver.findElement(By.className("error"));
	    log.error("Error in sign up process.");
    	
    }catch(NoSuchElementException ne){
    	log.info("Sign up successful.");
    }
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
