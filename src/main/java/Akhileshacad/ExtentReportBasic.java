package Akhileshacad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBasic {
	public ExtentReports extent;
	@BeforeTest
	public void config() {
		// Extent Reports(main class), ExtentSparkReporter (config File)
		String path=System.getProperty("user.dir")+"\\reports\\index.html"; //after + we want new path to add to it
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);// this is responsible for creating report
		reporter.config().setReportName("Web Automation Akhil");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();// this is main class for Tracking the things.
		extent.attachReporter(reporter); // Here is link of config with main class
		extent.setSystemInfo("Tester", "Akhilesh Rawat");
	}
	@Test
	public void intialDemo()
	{
		extent.createTest("initialDemo");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/#/index");
		System.out.println(driver.getTitle());
		extent.flush();// this is to stop monitoring
		
	}

}
