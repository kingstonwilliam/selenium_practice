package testCases;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import commonFunction.CommonFunction;
import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;
import pageObject.SchoolOnBoardDetailsObject;
import pageObject.SchoolOnBoardSubjectObject;

//changed property method to static 
public class TestSchoolOnBoardDetails extends CommonFunction  {
	@Test(priority=(0))
	public static void SchoolDetails() throws AWTException, IOException, InterruptedException {
		ExtentTest test14 = extent.createTest("TC014 - Enter Correct Data for OnBoarding");
		try {
			Thread.sleep(3000);
			 loadPropertyFile();
			 PageFactory.initElements(driver, SchoolOnBoardDetailsObject.class);
		 SchoolOnBoardDetailsObject.UploadFile.click(); 
		String filePath = "C:\\Users\\macappstudio\\School_img\\school.jpg";
		 StringSelection selection = new StringSelection(filePath);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		 Thread.sleep(3000);
		 Robot robot= new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(5000);
			 //SchoolOnBoardDetailsObject.UploadFile.sendKeys(properties.getProperty("fileUpload"));
			 SchoolOnBoardDetailsObject.ClickSchoolSyllabus.click();
			 Select dropdown = new Select(SchoolOnBoardDetailsObject.ClickSchoolSyllabus);
			 dropdown.selectByVisibleText(properties.getProperty("syllabus"));
			 SchoolOnBoardDetailsObject.ClickAffilationNumber.sendKeys(properties.getProperty("affilationNumber"));
			 SchoolOnBoardDetailsObject.ClickMediumOfSchool.click();
			 Select SchoolMediumdropdown = new Select(SchoolOnBoardDetailsObject.ClickMediumOfSchool);
			 SchoolMediumdropdown.selectByVisibleText(properties.getProperty("mediumOfSchool"));
			 SchoolOnBoardDetailsObject.ClickEnterContactName.sendKeys(properties.getProperty("contactName"));
			 SchoolOnBoardDetailsObject.ClickEnterNumber.sendKeys(properties.getProperty("contactNumber"));
			 SchoolOnBoardDetailsObject.ClickWebsiteAddress.sendKeys(properties.getProperty("websiteAdress"));
			 SchoolOnBoardDetailsObject.ClickEnterLatitude.sendKeys(properties.getProperty("latitude"));
			 SchoolOnBoardDetailsObject.ClickEnterLongitude.sendKeys(properties.getProperty("longitude"));
			 SchoolOnBoardDetailsObject.ClickEnterAdressLine1.sendKeys(properties.getProperty("address1"));
			 SchoolOnBoardDetailsObject.ClickEnterAdressLine2.sendKeys(properties.getProperty("address2"));
			 SchoolOnBoardDetailsObject.ClickChooseCountry.click();
			 Select countryDropDown = new Select(SchoolOnBoardDetailsObject.ClickChooseCountry);
			 countryDropDown.selectByVisibleText(properties.getProperty("country"));
			 SchoolOnBoardDetailsObject.ClickChooseState.click();
			 Select stateDropDown = new Select(SchoolOnBoardDetailsObject.ClickChooseState);
			 stateDropDown.selectByVisibleText(properties.getProperty("state"));
			 SchoolOnBoardDetailsObject.ClickChooseCity.click();
			 Select cityDropDown = new Select(SchoolOnBoardDetailsObject.ClickChooseCity);
			 cityDropDown.selectByVisibleText(properties.getProperty("city"));
			 SchoolOnBoardDetailsObject.ClickEnterPincode.sendKeys(properties.getProperty("pincode"));
			 SchoolOnBoardDetailsObject.ClickContinue.click();
		}
		catch (Exception e) {
			// TODO: handle exception Robot robot= new Robot();
			 logger.error("Error in Email Password page");
	          Robot robot= new Robot();
	        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle rectangle= new Rectangle(screenSize);
	        BufferedImage source =robot.createScreenCapture(rectangle);
	        File destinationFile=new File("C:\\ss\\OnBoardSchoolDetails.png");
	        ImageIO.write(source, "png", destinationFile);
         	test14.log(Status.FAIL, "Error in Email Password page",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\OnBoardSchoolDetails.png").build());
		}
		
	}
	@Test(priority=(1))
	public void SchoolSubjects() {
		ExtentTest test15 = extent.createTest("TC015 - Download sample file");
		try {
			Thread.sleep(3000);
			 loadPropertyFile();
			 PageFactory.initElements(driver, SchoolOnBoardSubjectObject.class);
			 SchoolOnBoardSubjectObject.ClickDownload.click();
			 
			 Thread.sleep(3000);
//			 SchoolOnBoardDetailsObject.reU.click(); 
			 
			 
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
             

