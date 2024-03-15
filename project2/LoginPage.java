package project2;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.units.qual.Current;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class LoginPage {
	static List<String> userName = new ArrayList<String>();
	static List<String> password = new ArrayList<String>();

	static WebDriver driver;
	long startTime;
	long endTime;

	@BeforeSuite
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
		

		startTime = System.currentTimeMillis();

	}

	@Test(priority=(1))
	public void readExcel() throws IOException {

		FileInputStream excel = new FileInputStream("C:\\Users\\macappstudio\\Desktop\\testdata2.xlsx");
		Workbook workbook = new XSSFWorkbook(excel);
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
		}

	}
  @DataProvider
	public void login(String uName, String pWord) {	
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
        driver.manage().window().maximize();

		driver.get("https://heycampus.site/super-admin/login");
		WebElement userName = driver.findElement(By.id("user_id"));
		userName.sendKeys(uName);
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys(pWord);
		WebElement loginButton = driver
		.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[3]/a/button"));
		loginButton.click();
		
		
		// driver.quit();
	}
  @Test(priority=(3))
  public void clickManageSchool() throws InterruptedException {
	  Thread.sleep(6000);
  	WebElement manageSchoolbtn=driver.findElement(By.xpath("/html/body/div[2]/nav/div/div/ul/li[2]/a/span"));
  	manageSchoolbtn.click();
  	System.out.println("successfully clicked manage school");
  }
  @Test(priority=(4))
  public void clickInviteSchoolBtn() throws InterruptedException {
	  Thread.sleep(4000);
	  WebElement inviteSchoolBtn= driver.findElement(By.xpath("//*[@id=\"invitedSchool\"]/div/div[1]/div[2]/div[3]/div/button"));
	  inviteSchoolBtn.click();
  }
  @Test(priority=(5))
  public void inviteSchoolForm() throws InterruptedException {
	  Thread.sleep(3000);
	  	WebElement SchoolName= driver.findElement(By.id("invite_schoolname"));
	  	SchoolName.click();
	  	SchoolName.sendKeys("abc academy");
	  	WebElement SiteName= driver.findElement(By.id("invite_schoolsite"));
	  	SiteName.click();
	  	SiteName.sendKeys("www.academy.com");
	  	WebElement EmailId= driver.findElement(By.id("invite_schoolemail"));
	  	EmailId.click();
	  	EmailId.sendKeys("kingstondemoacc@gmail.com");
	  	WebElement CoursePlanManagementChkBox= driver.findElement(By.xpath("//*[@id=\"invit_modal\"]/div/div/div[2]/div[4]/div/ul/li[26]/label"));
	  	CoursePlanManagementChkBox.click();
	  	WebElement calenderManagementChkBox= driver.findElement(By.xpath("//*[@id=\"invit_modal\"]/div/div/div[2]/div[4]/div/ul/li[27]/label"));
	  	calenderManagementChkBox.click();
	  	WebElement NonTeachingEmp= driver.findElement(By.xpath("//*[@id=\"invit_modal\"]/div/div/div[2]/div[4]/div/ul/li[28]/label"));
	  	NonTeachingEmp.click();
	  	WebElement AttendanceManagement= driver.findElement(By.xpath("//*[@id=\"invit_modal\"]/div/div/div[2]/div[4]/div/ul/li[29]/label"));
	  	AttendanceManagement.click();
	  	WebElement MarketPlaceCommission= driver.findElement(By.id("invite_schoolcommission"));
	  	MarketPlaceCommission.click();
	  	MarketPlaceCommission.sendKeys("10");
	  	WebElement SmsCredit= driver.findElement(By.xpath("//*[@id=\'invite_schoolsms_credits\']"));
	  	SmsCredit.click();
	  	SmsCredit.sendKeys("100");
	  	WebElement WhatsApp= driver.findElement(By.xpath("//*[@id=\'invite_schoolwa_credits\']"));
	  	WhatsApp.click();
	  	WhatsApp.sendKeys("40");
	  	WebElement AccountId= driver.findElement(By.id("school_account_id"));
	  	AccountId.click();
	  	AccountId.sendKeys("3577657677");
	  	WebElement CommissionAmt= driver.findElement(By.id("school_commission_amount"));
	  	CommissionAmt.click();
	  	CommissionAmt.sendKeys("100");
	  	WebElement SubmtBtn= driver.findElement(By.id("invite-send-btn"));
	  	SubmtBtn.click();
  }
  @Test(priority=(6))
  public void OpenGooogle() throws InterruptedException {
	//  driver.navigate().to("https://www.google.com/"); 
	//	Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
 		driver.get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
          // tabs.add("https://accounts.google.com/v3/signin/challenge/pwd?TL=AHNYTITRy-5l72vsZNh5qOO94REePsmaQWCh5vlc-YWsVhyZj0LfTxHKnytnFtEo&checkConnection=youtube%3A353&checkedDomains=youtube&cid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&dsh=S-1476146998%3A1706096840567095&emr=1&flowEntry=ServiceLogin&flowName=GlifWebSignIn&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&ifkv=ASKXGp0ZqmW9hJ6icOC3khAMTUocaxctSbHMWKsiUh6IQp9Mr6g5VICqKlKTRGx0Fz6_ieJTXllipw&osid=1&pstMsg=1&service=mail&theme=glif");
		  WebElement emailid=driver.findElement(By.id("identifierId"));
		  emailid.click();
		  emailid.sendKeys("kingstondemoacc@gmail.com");
		  WebElement nextbutton=driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span"));
		  nextbutton.click();

		 
		  

		 
  }
  @Test(priority=(7))
  public void LoginPass() throws InterruptedException{
	  Thread.sleep(2000);
		
		 WebElement password = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
		  password.click();
		  password.sendKeys("20062002@king");
		  WebElement nextbutton2=driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		  nextbutton2.click();
  }
  
  @Test(priority=(8))
  public void EmailSearchFilter() throws InterruptedException {
  Thread.sleep(5000);
//	((JavascriptExecutor)driver).executeScript("window.open()");
//	 ArrayList<String> tabss= new ArrayList<>(driver.getWindowHandles());
//	 driver.switchTo().window(tabss.get(2));
	// driver.get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
	  WebElement SearchFilter = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	  SearchFilter.click();
	  SearchFilter.sendKeys("Hey Campus");
	   Actions actions = new Actions(driver);
	   actions.sendKeys(Keys.ENTER).perform();

  }
   @Test(priority=(9))
   public void ClickInboxMsg() throws InterruptedException{
	   Thread.sleep(5000);

	   WebElement ClickMsg = driver.findElement(By.id(":5d"));
	   ClickMsg.click();
   }
   @Test(priority=(10))
   public void FetchingData() {
	    WebElement table = driver.findElement(By.xpath("//*[@id=\":6d\"]/div[1]/table/tbody/tr[4]/td/div/table"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    for (int i = 0; i < rows.size(); i++) {
	        WebElement row = rows.get(i);
	        System.out.println(row.getText());
	      
	    }
	    System.out.println("successfully data fetched");
	}
//    @Test
//    public void clickLoginFromMail() throws InterruptedException {
//    	Thread.sleep(2000);
//    	WebElement login= driver.findElement(By.xpath("//*[@id=\":6d\"]/div[1]/table/tbody/tr[4]/td/div/table/tbody[2]/tr/td/div/a/button"));
//    	login.click();
//    	
//    }
    @Test(priority=(11))
    public void LoginGreatify() throws InterruptedException {
    	((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
 		driver.get("https://wwwacademycom.heycampus.site/school/login");
    	Thread.sleep(2000);
    	WebElement Uname= driver.findElement(By.id("name1"));
    	Uname.click();
    	Uname.sendKeys("HCSCHOOL0319");
    	WebElement Pass= driver.findElement(By.id("name2"));
    	Pass.sendKeys("5H7$25S3HWC");
    	WebElement SubBtn= driver.findElement(By.xpath("/html/body/section/div/div[2]/div/form/div[2]/a/button"));
    	SubBtn.click();
    }
    
    
   
	@Test(priority=(2))
	public void executeTest() {
		for (int i = 0; i < userName.size(); i++) {
			login(userName.get(i), password.get(i));
		}
	}


@AfterSuite
public void endingTime() {
	
	 endTime=System.currentTimeMillis();
	//driver.quit();
	System.out.println("Time taken to execute"+(startTime-endTime));
	System.out.println("all the test cases runs sucessfully");
}
	

//	public static void main(String[] args) throws IOException, InterruptedException {
//		LoginPage execute = new LoginPage();
//		execute.readExcel();
//		execute.executeTest();
//		execute.clickManageSchool();	
//		execute.clickInviteSchoolBtn();
//		execute.inviteSchoolForm();
//		execute.OpenGooogle();
//		execute.LoginPass();
//		execute.EmailSearchFilter();
//		execute.ClickInboxMsg();
//		execute. FetchingData();
//		//execute.clickLoginFromMail();	
//		execute.LoginGreatify();
//		//execute.SigningInGmail();
//		// execute.endingTime();
//		System.out.println("username List :" + userName);
//		System.out.println("password List :" + password);
//
//	}

}
