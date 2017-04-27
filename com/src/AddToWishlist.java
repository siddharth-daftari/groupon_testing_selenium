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

public class AddToWishlist {
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
    
    log = Logger.getLogger(AddToWishlist.class);
  }

  @Test
  public void testAddToWishList() throws Exception {
  Actions build = new Actions(driver);
  WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.get(baseUrl + "/");
    
    try{
    	driver.findElement(By.id("nothx")).click();
    }catch(Exception e){
    	//ignore exception
    }
    
    driver.findElement(By.id("ls-user-signin")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector("label.twelve")).click();
    driver.findElement(By.id("email-input")).clear();
    driver.findElement(By.id("email-input")).sendKeys("p1049058@mvrht.com");
    driver.findElement(By.id("password-input")).clear();
    driver.findElement(By.id("password-input")).sendKeys("passwordabc");
    driver.findElement(By.id("remember-me-checkbox")).click();
    driver.findElement(By.id("signin-button")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Getaways")));
    driver.findElement(By.linkText("Getaways")).click(); 
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"flash-deals\"]/div/figure[1]/a/div/div[2]/div[5]/div")));
    WebElement we1 = driver.findElement(By.xpath("//*[@id=\"flash-deals\"]/div/figure[1]/a/div/div[2]/div[5]/div"));
 
    we1.click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"purchase-cluster\"]/div[5]/button"))); 
    driver.findElement(By.xpath("//*[@id=\"purchase-cluster\"]/div[5]/button")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("header-wishlist-heart")).click();
    
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
