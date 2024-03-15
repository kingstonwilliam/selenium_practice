package testCases;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import commonFunction.CommonFunction;
import pageObject.DataFetchingObject;
import pageObject.EmailLoginPageObjects;
import pageObject.EmailSearchFilterObject;
import pageObject.InboxMsgObject;
import pageObject.LoginGreatifyObject;
import pageObject.Manage_School_Object;
import pageObject.OpenNewTabGmailObject;

public class TestEmailForPrivateCredential extends CommonFunction {
 
    String Emailurl;

    @Test (priority = (0))
    public void emailLoginUserId() throws IOException, AWTException {
    	ExtentTest test7 = extent.createTest("TC007 - Email Login UserId");
    	try {
      //  launchBrowser();
        loadPropertyFile();
        Emailurl = properties.getProperty("emailUrl"); 
        PageFactory.initElements(driver, OpenNewTabGmailObject.class);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(Emailurl);
        OpenNewTabGmailObject.loginUserId.sendKeys(properties.getProperty("emailAddress"));
        OpenNewTabGmailObject.nextBtn.click();
		test7.log(Status.PASS, "Successfully Entered userId");
		logger.info("TC007 - Email Login UserId");
		logger.info("Successfully Entered userId");

    	}
    	catch (Exception e) {
            logger.error("Error in userId");
            Robot robot= new Robot();
	        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle rectangle= new Rectangle(screenSize);
	        BufferedImage source =robot.createScreenCapture(rectangle);
	        File destinationFile=new File("C:\\ss\\emailLoginUserId.png");
	        ImageIO.write(source, "png", destinationFile);
        	test7.log(Status.FAIL, "Error in userId",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\emailLoginUserId.png").build());

    	}
    }
     @Test (priority = (1))
    public void emailLoginUserPass() throws InterruptedException, IOException, AWTException {
     	ExtentTest test8 = extent.createTest("TC008 - Email Login Password");
    	 try {
    	 loadPropertyFile();
        Thread.sleep(5000);
        OpenNewTabGmailObject.password.sendKeys(properties.getProperty("emailPass"));
        OpenNewTabGmailObject.nextbtn2.click();
		test8.log(Status.PASS, "Successfully Logged in");
       logger.info("TC008 - Email Login Password");
       logger.info("Successfully Logged in");
    	 }
    	 catch (Exception e) {
          logger.error("Error in Email Password page");
          Robot robot= new Robot();
	        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle rectangle= new Rectangle(screenSize);
	        BufferedImage source =robot.createScreenCapture(rectangle);
	        File destinationFile=new File("C:\\ss\\emailLoginUserPass.png");
	        ImageIO.write(source, "png", destinationFile);
         	test8.log(Status.FAIL, "Error in Email Password page",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\emailLoginUserPass.png").build());

    	 }
    }

    @Test (priority = (2))
    public void emailSearchFilter() throws InterruptedException, IOException, AWTException {
     	ExtentTest test9 = extent.createTest("TC009 - Email Search Filter");

    	try {
    	 loadPropertyFile();
        Thread.sleep(5000);
        PageFactory.initElements(driver, EmailSearchFilterObject.class);
        EmailSearchFilterObject.searchFilter.click();
        EmailSearchFilterObject.searchFilter.sendKeys(properties.getProperty("searchFilterMsg"));
        EmailSearchFilterObject.actions.sendKeys(Keys.ENTER).perform();
		test9.log(Status.PASS, "Successfully Data Searched in Email Search Filter");
		logger.info("TC009 - Email Search Filter");
		logger.info("Successfully Data Searched in Email Search Filter");

    }
    catch(Exception e) {
     	logger.error("Error in Email Search Filter");
     	 Robot robot= new Robot();
	        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle rectangle= new Rectangle(screenSize);
	        BufferedImage source =robot.createScreenCapture(rectangle);
	        File destinationFile=new File("C:\\ss\\emailSearchFilter.png");
	        ImageIO.write(source, "png", destinationFile);
	     	test9.log(Status.FAIL, "Error in Email Search Filter",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\emailSearchFilter.png").build());


    }
    }
     @Test (priority = (3))
    public void clickInboxMsg() throws InterruptedException, IOException, AWTException {
      	ExtentTest test10 = extent.createTest("TC010 - Click Inbox Msg in Email");

    	 try {
        Thread.sleep(5000);
        PageFactory.initElements(driver, InboxMsgObject.class);
        InboxMsgObject.ClickInboxMsg.click();
		test10.log(Status.PASS, "Successfully Inbox Msg Clicked");
		logger.info("TC010 - Click Inbox Msg in Email");
		logger.info("Successfully Inbox Msg Clicked");

    	 }
    	 catch(Exception e) {
                logger.error("Error in Email InBox Message");
                Robot robot= new Robot();
		        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		        Rectangle rectangle= new Rectangle(screenSize);
		        BufferedImage source =robot.createScreenCapture(rectangle);
		        File destinationFile=new File("C:\\ss\\clickInboxMsg.png");
		        ImageIO.write(source, "png", destinationFile);
    	     	test10.log(Status.FAIL, "Error in InBox Message",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\clickInboxMsg.png").build());

    	 }
    }
      @Test (priority = (4))
    public void inboxDataFetching() throws AWTException, IOException {
	      	ExtentTest test11 = extent.createTest("TC011 - Fetching UserId And Password From Inbox Message");

    	  try {

        PageFactory.initElements(driver, DataFetchingObject.class);
	    WebElement table = driver.findElement(By.xpath("//*/div[1]/table/tbody/tr[4]/td/div/table"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            System.out.println(row.getText());
        }
        System.out.println("successfully data fetched");
		test11.log(Status.PASS, "Successfully data Fetched ");
		logger.info("TC011 - Fetching UserId And Password From Inbox Message");
		logger.info("Successfully data Fetched");

    }
    	  catch(Exception e) {
                   logger.error("Error in Email Inbox Data Fetching");
                   Robot robot= new Robot();
   		        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
   		        Rectangle rectangle= new Rectangle(screenSize);
   		        BufferedImage source =robot.createScreenCapture(rectangle);
   		        File destinationFile=new File("C:\\ss\\inboxDataFetching.png");
   		        ImageIO.write(source, "png", destinationFile);
   	  	     	test11.log(Status.FAIL, "Error in Inbox Data Fetching ",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\inboxDataFetching.png").build());
    		  }
    	  }
  @Test (priority=(5))
    public void clickLoginGreatifyBtn() throws AWTException, IOException {
    	ExtentTest test12 = extent.createTest("TC012 - Click Login Greatify Button");
	  try {
        PageFactory.initElements(driver, LoginGreatifyObject.class);
        LoginGreatifyObject.loginBtn.click();
		test12.log(Status.PASS, "Successfully Login Button Clicked");
		logger.info("TC012 - Click Login Greatify Button");
		logger.info("Successfully Login Button Clicked");
	  }
	  catch (Exception e) {
          logger.error("Error in Clicking Login Button");
          Robot robot= new Robot();
	        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle rectangle= new Rectangle(screenSize);
	        BufferedImage source =robot.createScreenCapture(rectangle);
	        File destinationFile=new File("C:\\ss\\clickLoginGreatifyBtn.png");
	        ImageIO.write(source, "png", destinationFile);
	     	test12.log(Status.FAIL, "Error in Clicking Login Button",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\clickLoginGreatifyBtn.png").build());

	  }
  }
  @Test (priority=(6))
  public void loginGreatify() throws IOException, AWTException {
	  
  	ExtentTest test13 = extent.createTest("TC013 - Enter Correct UserId and Password");

	  try {
	  loadPropertyFile();
	  ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(2));
      PageFactory.initElements(driver, LoginGreatifyObject.class);
      LoginGreatifyObject.userId.sendKeys(properties.getProperty("greatifySchoolDashBoardUserId"));
      LoginGreatifyObject.passWord.sendKeys(properties.getProperty("greatifySchoolDashBoardPassword"));
      LoginGreatifyObject.subBtn.click();
		test13.log(Status.PASS, "Successfully Logged in");
		logger.info("TC013 - Enter Correct UserId and Password");
		logger.info("Successfully Logged in");

	  }
	  catch(Exception e) {
	     	logger.error("Error in Loggin page");
	     	 Robot robot= new Robot();
		        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		        Rectangle rectangle= new Rectangle(screenSize);
		        BufferedImage source =robot.createScreenCapture(rectangle);
		        File destinationFile=new File("C:\\ss\\loginGreatify.png");
		        ImageIO.write(source, "png", destinationFile);
		     	test13.log(Status.FAIL, "Error in Loggin page",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\loginGreatify.png").build());
	  }
  }
}
