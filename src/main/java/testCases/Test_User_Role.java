package testCases;

import static commonFunction.CommonFunction.logger;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import commonFunction.CommonFunction;
import pageObject.EmailLoginPageObjects;
import pageObject.Manage_School_Object;

public class Test_User_Role extends CommonFunction {
	// static Logger logger = Logger.getLogger(Test_User_Role.class);
	static List<String> userName = new ArrayList<String>();
	static List<String> password = new ArrayList<String>();

	@Test(priority = (1))
	public void readExcel() throws IOException {
		// PropertyConfigurator.configure("log4j.properties");
		ExtentTest test2 = extent.createTest("TC002 - Fetching Data From Excel");
		FileInputStream excel = new FileInputStream("C:\\Users\\macappstudio\\Desktop\\testdata2.xlsx");
		try (Workbook workbook = new XSSFWorkbook(excel)) {
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row rowValue = rowIterator.next();
				Iterator<Cell> columnIterator = rowValue.iterator();
				int i = 2;
				while (columnIterator.hasNext()) {
					if (i % 2 == 0) {
						userName.add(columnIterator.next().toString());
					} else {
						password.add(columnIterator.next().toString());
					}
					i++;
				}
				test2.log(Status.PASS, "Fetched Data Successfully From Excel");
				logger.info("TC002 - Fetching Data From Excel");
				logger.info("Successfully fetched Data from Excel");
			}
		} catch (Exception e) {
			System.err.println("Error in readExcel method: " + e.getMessage());
			logger.fatal("error in fetching data in Excel");
			
		}

	}

	@Test(priority = 2)
	public void executeTest() throws AWTException, IOException {
		ExtentTest test3 = extent.createTest("TC003 - Executing data from Excel");
		try {
			for (int i = 0; i < userName.size(); i++) {
				loginTest(userName.get(i), password.get(i));
			}
			test3.log(Status.PASS, "Getting user id and password and storing it in a variable");
			logger.info("TC003 - Fetching Data From Excel");
			logger.info("Successfully data executed");

		} catch (Exception e) {
			// Handle the exception, log it, and mark the test as failed
			test3.log(Status.FAIL, "Fetching Data From Excel Failed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\loginTest.png").build());

			// You can also log the stack trace for more detailed information
			e.printStackTrace();
			logger.fatal("error in executing data ");
			 Robot robot= new Robot();
		        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		        Rectangle rectangle= new Rectangle(screenSize);
		        BufferedImage source =robot.createScreenCapture(rectangle);
		        File destinationFile=new File("C:\\ss\\executeTest.png");
		        ImageIO.write(source, "png", destinationFile);
		        test3.log(Status.FAIL, "Fetching Data From Excel Failed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\executeTest.png").build());

		}
	}

	@DataProvider
	public static void loginTest(String uName, String pWord) throws AWTException, IOException {
		ExtentTest test4 = extent.createTest("TC004 - Sending userName and Password through sendkeys");
		logger.info("UserId :"+uName);
		logger.info("Password :"+pWord);
		try {
			PageFactory.initElements(driver, EmailLoginPageObjects.class);
			EmailLoginPageObjects.userName.sendKeys((uName));
			EmailLoginPageObjects.passWord.sendKeys((pWord));
			EmailLoginPageObjects.loginbtn.click();
			Assert.assertEquals(uName, "HCADMIN001");
			Assert.assertEquals(pWord, "Edberg@123");
			test4.log(Status.PASS, "Successfully logged in");
			logger.info("TC004 - Sending userName and Password through sendkeys");
			logger.info("successfully logged in");

		} catch (Exception e) {
			logger.info("Unable to login check your emailId and password");
			 Robot robot= new Robot();
		        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		        Rectangle rectangle= new Rectangle(screenSize);
		        BufferedImage source =robot.createScreenCapture(rectangle);
		        File destinationFile=new File("C:\\ss\\loginTest.png");
		        ImageIO.write(source, "png", destinationFile);
				test4.log(Status.FAIL, "Login Failed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\loginTest.png").build());

		}
	}

	@Test(priority = (3))
	public void manageSchoolTest() throws InterruptedException, AWTException, IOException {
		ExtentTest test5 = extent.createTest("TC005 - Click Manage School Button");
		try {
			Thread.sleep(8000);
			PageFactory.initElements(driver, Manage_School_Object.class);
			Manage_School_Object.clickManageSchoolBtn.click();
			test5.log(Status.PASS, "Successfully clicked Manage School Button");
			logger.info("TC005 - Click Manage School Button");
			logger.info("Successfully clicked Manage School Button");
		} catch (Exception e) {
			logger.error("Unable to click Manage School Button");
			 Robot robot= new Robot();
		        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		        Rectangle rectangle= new Rectangle(screenSize);
		        BufferedImage source =robot.createScreenCapture(rectangle);
		        File destinationFile=new File("C:\\ss\\manageSchoolTest.png");
		        ImageIO.write(source, "png", destinationFile);
				test5.log(Status.FAIL, "Unable to click Manage School Button",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\manageSchoolTest.png").build());

		}
	}

	@Test(priority = (4))
	public void clickInviteScdhoolBtn() throws InterruptedException, AWTException, IOException {
		ExtentTest test6 = extent.createTest("TC006 - Click Invite School Button and fill the form");
		try {
			Thread.sleep(4000);
			PageFactory.initElements(driver, Manage_School_Object.class);
			Manage_School_Object.clickInviteSchool.click();
			Thread.sleep(2000);
			Manage_School_Object.schoolName.sendKeys(properties.getProperty("schoolName"));
			Manage_School_Object.siteName.sendKeys(properties.getProperty("siteName"));
			Manage_School_Object.emailId.sendKeys(properties.getProperty("emailAddress"));
			Manage_School_Object.coursePlanManagementChkBox.click();
			Manage_School_Object.calenderManagementChkBox.click();
			Manage_School_Object.nonTeachingEmp.click();// nonTeachingEmp
			Manage_School_Object.attendanceManagement.click();
			Manage_School_Object.smsCredit.sendKeys(properties.getProperty("smsCredits"));
			Manage_School_Object.whatsApp.sendKeys(properties.getProperty("whatsApp"));
			Manage_School_Object.marketPlaceCommision.sendKeys(properties.getProperty("marketplaceCommission"));
			Manage_School_Object.AccountId.sendKeys(properties.getProperty("accountId"));
			Manage_School_Object.commisionAmt.sendKeys(properties.getProperty("commissionAmount"));
			Manage_School_Object.submtBtn.click();
			test6.log(Status.PASS, "Successfully form filled");
			logger.info("TC006 - Click Invite School Button and fill the form");
			logger.info("Successfully form filled");

		} catch (Exception e) {
			Robot robot= new Robot();
	        java.awt.Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
	        Rectangle rectangle= new Rectangle(screenSize);
	        BufferedImage source =robot.createScreenCapture(rectangle);
	        File destinationFile=new File("C:\\ss\\clickInviteScdhoolBtn.png");
	        ImageIO.write(source, "png", destinationFile);
			test6.log(Status.FAIL, "Error in filling form",MediaEntityBuilder.createScreenCaptureFromPath("C:\\ss\\clickInviteScdhoolBtn.png").build());
		}

	}

}
