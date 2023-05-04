package day9;


import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;


import org.testng.annotations.BeforeSuite;

import org.testng.annotations.AfterSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          

public class class5 {
	WebDriver driver;
  @Test
  public void openURL() throws InterruptedException {
	  Thread.sleep(3000);
	  WebElement userName = driver.findElement(By.name("username"));
	  WebElement password = driver.findElement(By.name("password"));
	  WebElement submit = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
	  userName.sendKeys("Suvitha");
	  password.sendKeys("12345");
	  submit.click();
	  Thread.sleep(3000);
	  String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	  //String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	  String actualURL = driver.getCurrentUrl();
	  Assert.assertEquals(expectedURL, actualURL);
  }
  
  @BeforeSuite
  public void setup() {
	  System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
	  //WebDriverManager.chromedriver().setup();
	  ChromeOptions co = new ChromeOptions();
	  co.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(co);
	  driver.manage().window().maximize();
	  String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	  driver.get(url);
	  driver.manage().window().maximize();
  }
  
  @AfterSuite
  public void teardown() {
	  driver.close();
  }
}