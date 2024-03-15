package seleniumpractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


// headless is used for getting data without seeing the ui
public class HeadLessChrome {
 public static void main(String[] args) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\macappstudio\\eclipse-workspace\\LearningSelenium\\driver files\\chromedriver (1).exe");
 ChromeOptions  options= new ChromeOptions();
 
 options.addArguments("--headless");
 ChromeDriver driver= new ChromeDriver(options);
 
 driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804944%7Cb%7Cfacebook%7C&placement=&creative=550525804944&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-592856129%26loc_physical_ms%3D9061895%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=Cj0KCQiAwP6sBhDAARIsAPfK_wbGEJvWqQ1mWSlPxItYlABpZWdiT4sVqc-D631n8AVTEL7UCGSMiKAaAqyxEALw_wcB");
 System.out.println(driver.getTitle());
 
 }
}
