package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataFetchingObject {
@FindBy(xpath = "//*[@id=\":6d\"]/div[1]/table/tbody/tr[4]/td/div/table")
  public static WebElement table;
}
