package commonFunction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import logger4jPractice.PropertyLog4j;

public class CommonFunction {
	
	public static ExtentReports extent;
   public static ExtentTest test;
	public static Logger logger= Logger.getLogger(CommonFunction.class);
	public static WebDriver driver=null;
	public static Properties properties=null;

	public static Properties loadPropertyFile() throws IOException {	
		FileInputStream fileInputStream= new FileInputStream("config.properties");
	properties = new Properties();
	properties.load(fileInputStream);
	return properties;
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./GreatifyTestReport.html");
	          extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
		loadPropertyFile();
		String browser=properties.getProperty("browser");
	     String url=properties.getProperty("url");
	     String driverLocation=properties.getProperty("driverLocation");
       
	     if(browser.equalsIgnoreCase("chrome")) {
	        ExtentTest test = extent.createTest("TC001 - open google");
	    	 System.setProperty("webdriver.chrome.driver",driverLocation);
	    	 ChromeOptions option =new ChromeOptions();
	 		option.addArguments("--disable-notifications");
	 		driver = new ChromeDriver(option);
	 		 driver.get(url);
	 		test.log(Status.PASS, "Browser Launched Successfully");
 		 String title = driver.getCurrentUrl();
	 		 Assert.assertEquals(title,"https://heycampus.site/super-admin/login"); 	
	 		 System.out.println(title);
	 		 logger.info("successfully browser launched");
	 		driver.manage().window().maximize();
	     }
	     }

	@AfterSuite
	public void tearDown() {
        extent.flush();

	}
	
}
