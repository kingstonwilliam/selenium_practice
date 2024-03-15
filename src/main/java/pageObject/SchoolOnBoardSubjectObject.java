package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SchoolOnBoardSubjectObject {
	 @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div[4]/a")
		public static WebElement ClickDownload;
	 @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[2]/div[5]/div[2]/div[2]/label")
	 public static WebElement reUploadFiles;
}
