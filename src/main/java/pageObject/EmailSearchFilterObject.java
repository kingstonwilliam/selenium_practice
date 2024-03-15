package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import commonFunction.CommonFunction;

public class EmailSearchFilterObject extends CommonFunction{
	public static Actions actions = new Actions(driver);
	@FindBy(xpath = "(//input[@type='text'])[2]")
   public static WebElement searchFilter;
}
