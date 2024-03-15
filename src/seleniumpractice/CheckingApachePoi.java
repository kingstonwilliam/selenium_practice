package seleniumpractice;
/* 1.creating a class called CheckingApachePoi
   2.creating arraylist to store username and password
   3.creating method called readexcel to get data from excel and iterating the method 
     by giving condition and storing the data in the array list.
   4.creating a login method to check the username and password in the greatify login page.
   5.creating a execute method to execute the code one by one.
   6.finally creating object  to run the method */
   
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckingApachePoi {
	static List<String>userNameList=new ArrayList<String>();
	static List<String>passwordList=new ArrayList<String>();

public void readExcel() throws IOException {
	
	FileInputStream excel=new FileInputStream("C:\\Users\\macappstudio\\Desktop\\testdata1.xlsx");
	Workbook workbook= new XSSFWorkbook(excel);
	Sheet sheet= workbook.getSheetAt(0);
	Iterator<Row> rowIterator= sheet.iterator();
	while(rowIterator.hasNext()) {
		Row rowValue=rowIterator.next();
		Iterator<Cell>columnIterator=rowValue.iterator();
		int i=2;
		while(columnIterator.hasNext()) {
		if(i%2==0) {
			userNameList.add(columnIterator.next().toString());
		}else {
			passwordList.add(columnIterator.next().toString());
		}
		i++;	
		}
	}
	
}
public void login(String uName, String pWord) {
	System.setProperty("Webdriver.chrome.driver",
			"C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://heycampus.site/super-admin/login");
    WebElement userName=driver.findElement(By.id("user_id"));
	userName.sendKeys(uName);
	WebElement password=driver.findElement(By.id("user_password"));
	password.sendKeys(pWord);
	WebElement loginButton=driver.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/div[3]/a/button"));
	loginButton.click();
	//driver.quit();
}
public void executeTest() {
	for(int i=1;i<userNameList.size();i++){
		login(userNameList.get(i),passwordList.get(i));
	}
}
public static void main(String[] args) throws IOException {
	CheckingApachePoi usingPOI= new CheckingApachePoi();
	usingPOI.readExcel();
	usingPOI.executeTest();
	System.out.println("username List :"+ userNameList);
	System.out.println("password List :"+ passwordList);
}
}
