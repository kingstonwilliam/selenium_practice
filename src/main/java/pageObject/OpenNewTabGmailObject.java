package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewTabGmailObject{
	@FindBy(id = "identifierId")
	public static WebElement loginUserId;
	@FindBy(xpath = "//*[@id=\'identifierNext\']/div/button/span")
	public static WebElement nextBtn;
	@FindBy(xpath = "//*[@id=\'password\']/div[1]/div/div[1]/input")
    public static WebElement password;
	@FindBy(xpath="//*[@id=\"passwordNext\"]/div/button/span")
	public static WebElement nextbtn2;
   
}
