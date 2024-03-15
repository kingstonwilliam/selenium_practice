package TestNgPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelTesting {
	@Test
  public void google() {   
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.google.com/");
  }
	@Test
  public void bing() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.bing.com/");
  }
}
