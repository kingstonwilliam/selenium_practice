package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {

	// TODO Auto-generated method stub
	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver","C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		Actions act= new Actions (driver);
		 driver.findElement(By.id("email")).sendKeys("kingston@gmail.com");	
		act.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1))
		.sendKeys("ASDF23")
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(1))
		.sendKeys(Keys.ENTER).perform();


		//driver.quit();
	//driver.manage().window().maximize();	
		}
	

}
