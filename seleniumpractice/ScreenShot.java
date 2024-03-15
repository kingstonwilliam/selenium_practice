package seleniumpractice;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
    public static void main(String[] args) throws IOException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        // takes screenshot
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File("C:\\ss\\face.png"); // Fix the file path
//        FileHandler.copy(sourceFile, destinationFile);
//        // driver.close();
        
        Robot robot= new Robot();
        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle= new Rectangle(screenSize);
        BufferedImage source =robot.createScreenCapture(rectangle);
        File destinationFile=new File("C:\\ss\\report.png");
        ImageIO.write(source, "png", destinationFile);
      
    }
}
