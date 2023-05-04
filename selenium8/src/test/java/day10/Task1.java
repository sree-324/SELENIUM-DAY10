package day10;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1{
	static ExtentTest test;
	static ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	@BeforeClass
	public void startReport() {
		//ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
		//htmlReporter =  new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/extentReport.html");
		htmlReporter =  new ExtentHtmlReporter("D:\\extr2.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
       // htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	@Test
  public void Test1() {
		  WebDriverManager.chromedriver().setup();
			WebDriver  driver;
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(co);
			driver.get("https://www.godaddy.com/en-in");
			driver.manage().window().maximize();
			String actualTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
			String extractedTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, extractedTitle);
			String actualURL="https://www.godaddy.com/en-in";
			String extractedURL=driver.getCurrentUrl();
			Assert.assertEquals(actualURL, extractedURL);
			System.out.println("Smoke test");
			driver.quit();
			test = extent.createTest("Test Case 1", "The test case 1 has passed");
  }
	
}