package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginGreatifyObject {
@FindBy(linkText = "Login Now")
public static WebElement loginBtn;
@FindBy(id="name1")
public static WebElement userId;
@FindBy(id="name2")
public static WebElement passWord;
@FindBy(xpath = "/html/body/section/div/div[2]/div/form/div[2]/a/button")
public static WebElement subBtn;
}
