package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SchoolOnBoardDetailsObject {
    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[1]/div[3]/div/div[1]/label")
	public static WebElement UploadFile;
	@FindBy(id="name3")
	public static WebElement ClickSchoolSyllabus;
	
	@FindBy(id="name4")
	public static WebElement ClickAffilationNumber;
	
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[1]/div[3]/div/div[3]/div[1]/div/div[6]/select")
	public static WebElement ClickMediumOfSchool;
	
	@FindBy(partialLinkText = "English")
	public static WebElement SelectMediumOfSchool;
	
	@FindBy(id = "name6")
	public static WebElement ClickEnterContactName;
	
	@FindBy(id = "mobile_code")
	public static WebElement ClickEnterNumber;
	
	@FindBy(id="name8")
	public static WebElement ClickWebsiteAddress;
	
	@FindBy(id ="name9")
	public static WebElement ClickEnterLatitude;
	
	@FindBy(id = "name10")
	public static WebElement ClickEnterLongitude;
	
	
	//Address
	@FindBy(id = "name11")
	public static WebElement ClickEnterAdressLine1;
	
	@FindBy(id ="name12")
	public static WebElement ClickEnterAdressLine2;
	
	@FindBy(id ="name13")
	public static WebElement ClickChooseCountry;
	
	@FindBy(partialLinkText = "India")
	public static WebElement ChooseCountry;
	
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[1]/div[3]/div/div[3]/div[2]/div/div[4]/select")
	public static WebElement ClickChooseState;
	
	@FindBy(partialLinkText = "Delhi")
	public static WebElement ChooseState;
	
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[1]/div[3]/div/div[3]/div[2]/div/div[5]/select")
	public static WebElement ClickChooseCity;
	
	@FindBy(partialLinkText = "Delhi")
	public static WebElement ChooseCity;
	
	@FindBy(id = "name16")
	public static WebElement ClickEnterPincode;
	
	@FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div[1]/div[3]/div/div[4]/button")
	public static WebElement ClickContinue;
	
}
