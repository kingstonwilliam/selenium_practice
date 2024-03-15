package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummmyForm {
	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver",
				"C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/form");
		driver.findElement(By.id("first-name")).sendKeys("kingston");
		driver.findElement(By.id("last-name")).sendKeys("william");
		driver.findElement(By.id("job-title")).sendKeys("QA");
		driver.findElement(By.id("radio-button-1")).click();
		WebElement unchecked=driver.findElement(By.xpath("/html/body/div/form/div/div[4]/div[2]/input"));
		driver.findElement(By.id("checkbox-1")).click();
		driver.findElement(By.id("select-menu")).sendKeys("0-1");
		driver.findElement(By.id("datepicker")).sendKeys("06/22/2024");
		driver.findElement(By.linkText("Submit")).click();
        boolean status1= unchecked.isSelected();
        System.out.println(status1);
		 driver.quit();

	}
}
