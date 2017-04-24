package src;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyDeal {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  private Logger log;

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "https://www.groupon.com";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.maximize_window();
    
    log = Logger.getLogger(BuyDeal.class);
  }

  @Test
  public void testBuyDeal() throws Exception {
  Actions build = new Actions(driver);
  WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.get(baseUrl + "/");
    driver.findElement(By.id("nothx")).click();
    driver.findElement(By.id("ls-user-signin")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector("label.twelve")).click();
    driver.findElement(By.id("email-input")).clear();
    driver.findElement(By.id("email-input")).sendKeys("p1049058@mvrht.com");
    driver.findElement(By.id("password-input")).clear();
    driver.findElement(By.id("password-input")).sendKeys("passwordabc");
    driver.findElement(By.id("remember-me-checkbox")).click();
    driver.findElement(By.id("signin-button")).click();
    driver.findElement(By.linkText("Goods")).click();
    driver.findElement(By.linkText("For the Home")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Art"))); 
	
    driver.findElement(By.linkText("Art")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Canvas"))); 
    
    WebElement we1 = driver.findElement(By.xpath("//*[@id=\"browse-deals\"]/figure[1]/a"));
    we1.sendKeys(Keys.ENTER);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("trait-0")));
    
    driver.findElement(By.id("trait-0")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("trait-0-1")));
    
    driver.findElement(By.id("trait-0-1")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.id("trait-1")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("trait-1-1")));
    driver.findElement(By.id("trait-1-1")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.id("buy-link")).click();
    driver.findElement(By.id("bottom-proceed-to-checkout")).click();
    
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
