package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummyWebsite {
public static void main(String[] args) {
	System.setProperty("Webdriver.chrome.driver",
			"C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/v1/index.html");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	driver.findElement(By.className("btn_primary")).click();
	driver.findElement(By.className("shopping_cart_container")).click();
	driver.findElement(By.className("checkout_button")).click();
	driver.findElement(By.id("first-name")).sendKeys("standard_user");
	driver.findElement(By.id("last-name")).sendKeys("standard_user");
	driver.findElement(By.id("postal-code")).sendKeys("600066");
	driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();
	driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();
	driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();


	

	
	
	
	
	 driver.quit();

		
}
}
