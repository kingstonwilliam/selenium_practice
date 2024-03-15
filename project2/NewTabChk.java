package project2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTabChk {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("Webdriver.chrome.driver",
			"C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/select.xhtml;jsessionid=node0z6j6kknihm8917h60enb8923e78520.node0");
	Thread.sleep(6000);
    // Open a new tab using keyboard actions (Ctrl + T)
    Actions actions = new Actions(driver);
	Thread.sleep(6000);
    actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
    

}
}
