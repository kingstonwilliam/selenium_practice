package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailLoginPageObjects {
	@FindBy(id = "user_id")
   public static WebElement userName;
	@FindBy(id="user_password")
   public static WebElement passWord;
	@FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/div[3]/a/button")
   public static WebElement loginbtn;
}
