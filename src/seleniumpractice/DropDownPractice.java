package seleniumpractice;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice {
	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver",
				"C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml;jsessionid=node0z6j6kknihm8917h60enb8923e78520.node0");
		WebElement myElement = driver. findElement(By.xpath("//*[@id=\'j_idt87\']/div/div[1]/div[1]/div/div/select"));
		Select select = new Select(myElement); 
		select.selectByIndex(1);
		List<WebElement> listAllDropdown= select.getOptions();
		int size = listAllDropdown.size();
		System.out.println(size);
		for (WebElement all : listAllDropdown) { }
		WebElement element = driver.findElement(By.xpath("//*[@id='j_idt87:auto-complete\']/button"));
		   element.click();
		 WebElement selectElements=  driver.findElement(By.xpath("//*[@id=\'j_idt87:auto-complete_panel\']/ul/li[1]")) ;
		 selectElements.click();
		 driver.quit();
	}
}
