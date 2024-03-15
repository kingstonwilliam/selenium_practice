package seleniumpractice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;

import com.google.common.collect.ImmutableMap;

public class FileUpload {
public static void main(String[] args) {
	//uploading file 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
WebDriver driver= new ChromeDriver();
driver.get("https://www.leafground.com/select.xhtml;jsessionid=node0z6j6kknihm8917h60enb8923e78520.node0");
	//	ChromeOptions options = new ChromeOptions();
//	options.setCapability("goog:loggingPrefs", ImmutableMap.of("browser", "ALL"));
//	WebDriver driver = new ChromeDriver(options);
//
//	// Your Selenium code here...
//
//	// Print Chrome logs
//	LogEntries logs = driver.manage().logs().get("browser");
//	for (org.openqa.selenium.logging.LogEntry entry : logs) {
//	    System.out.println(entry.getMessage());
//	}

	//driver.quit();

}
}
