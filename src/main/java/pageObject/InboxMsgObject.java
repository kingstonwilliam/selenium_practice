package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxMsgObject {
   @FindBy(xpath = "//*[@id=\":6n\"]")
   public static WebElement ClickInboxMsg;
}
