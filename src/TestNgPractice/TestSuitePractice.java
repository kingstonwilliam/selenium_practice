package TestNgPractice;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSuitePractice{
	WebDriver driver;
	long startTime;
	long endTime;
@BeforeSuite
	public void launchBrowser(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
	 driver= new ChromeDriver();
	 startTime= System.currentTimeMillis();
	
	}
@Test
public void openGoogle() {
	driver.get("https://www.google.com/");
}
@Test
public void openBing() {
	driver.get("https://www.bing.com/");
}
@Test
public void openYahoo() {
	driver.get("https://in.search.yahoo.com/?fr2=inr");
}
@AfterSuite
public void endingTime() {
	 endTime=System.currentTimeMillis();
	driver.quit();
	System.out.println("Time taken to execute"+(startTime-endTime));
}
}