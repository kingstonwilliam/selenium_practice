package extentReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportPractice {
    public static ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
    public static ExtentReports extent = new ExtentReports();
    public static WebDriver driver;

    @BeforeSuite
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");

        extent.attachReporter(reporter);
        driver = new ChromeDriver();
    }

    @Test
    public void launchChrome() throws IOException {
        ExtentTest test1 = extent.createTest("TC001 - open google");

        driver.get("https://www.google.co.in/");
        String title = driver.getTitle();
        if (title.equals("google")) {
            test1.pass("Test Passed - Page title is Google");
        } else {
            test1.fail("Test Failed - Page title is not Google",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\face.png").build());
        }
    }
    @Test
    public void openBing() throws InterruptedException {
    	Thread.sleep(4000);
        ExtentTest test2 = extent.createTest("TC002 - open bing");

        driver.get("https://www.bing.com/");
        String title = driver.getTitle();
        if (title.equals("Bing")) {
            test2.pass("Test Passed - Page title is Google");
        } else {
            test2.fail("Test Failed - Page title is not openBing");
        }
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
        extent.flush();
    }
}
