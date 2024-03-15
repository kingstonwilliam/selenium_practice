package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Manage_School_Object {
	@FindBy(xpath = "/html/body/div[2]/nav/div/div/ul/li[2]/a/span")
	public static WebElement clickManageSchoolBtn;

	@FindBy(xpath = "//*[@id=\"invitedSchool\"]/div/div[1]/div[2]/div[3]/div/button")
	public static WebElement clickInviteSchool;

	@FindBy(id = "invite_schoolname")
	public static WebElement schoolName;

	@FindBy(id = "invite_schoolsite")
	public static WebElement siteName;

	@FindBy(id = "invite_schoolemail")
	public static WebElement emailId;

	@FindBy(xpath = "//*[@id=\"invit_modal\"]/div/div/div[2]/div[5]/div/ul/li[26]/label")
	public static WebElement coursePlanManagementChkBox;

	@FindBy(xpath = "//*[@id=\"invit_modal\"]/div/div/div[2]/div[5]/div/ul/li[27]/label")
	public static WebElement calenderManagementChkBox;

	@FindBy(xpath = "//*[@id=\"invit_modal\"]/div/div/div[2]/div[5]/div/ul/li[28]/label")
	public static WebElement nonTeachingEmp;

	@FindBy(xpath = "//*[@id=\"invit_modal\"]/div/div/div[2]/div[5]/div/ul/li[29]/label")
	public static WebElement attendanceManagement;

	@FindBy(id = "invite_schoolcommission")
	public static WebElement marketPlaceCommision;

	@FindBy(xpath = "//*[@id=\'invite_schoolsms_credits\']")
	public static WebElement smsCredit;

	@FindBy(xpath = "//*[@id=\'invite_schoolwa_credits\']")
	public static WebElement whatsApp;

	@FindBy(id = "school_account_id")
	public static WebElement AccountId;

	@FindBy(id = "school_commission_amount")
	public static WebElement commisionAmt;

	@FindBy(id = "invite-send-btn")
	public static WebElement submtBtn;

}
