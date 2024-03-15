package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

    String[][] data = {
            {"Admin1", "admin"},
            {"Admin1", "dummy"},
            {"Admin", "admin"},
            {"Admin", "admin"}
    };

    @DataProvider(name = "loginData")
    public String[][] loginDataProvider() {
        return data;
    }

    @Test(dataProvider = "loginData")
    public void login(String uName, String pword) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        WebElement userName = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        userName.sendKeys(uName);

        WebElement password = driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        password.sendKeys(pword);
       
        WebElement login = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        login.click();

        // Add assertions or verification steps as needed

        // Pause for 5 seconds (5000 milliseconds)
        

     //   driver.quit(); // Close the browser session
    }
}
