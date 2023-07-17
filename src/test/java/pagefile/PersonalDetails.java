package pagefile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetails {

	static WebDriver driver;
	
	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active'][1]")
	WebElement empIdtxtbox;

	@FindBy(xpath = "//label[text()='SSN Number']//following::input[1]")
	WebElement ssnNotxtbox;

	@FindBy(xpath = "//label[text()='SIN Number']//following::input[1]")
	WebElement sinNotxtbox;

	@FindBy(xpath = "//label[text()=\"Driver's License Number\"]//following::input[1]")
	WebElement drvrlcnsNotxtbox;

	@FindBy(xpath = "//label[text()='Date of Birth']//following::input[1]")
	WebElement dobtxtbox;

	@FindBy(xpath = "//label[text()='Employee Full Name']//following::input[1]")
	WebElement firstnametxtbox;

	@FindBy(xpath = "//label[text()='Employee Full Name']//following::input[2]")
	WebElement middlenametxtbox;

	@FindBy(xpath = "//label[text()='Employee Full Name']//following::input[3]")
	WebElement lastnametxtbox;

	@FindBy(xpath = "//form[@class='oxd-form'][1]/div[5]/button")
	WebElement savebtn;

	public PersonalDetails(WebDriver driver)
	{
		PersonalDetails.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void empIdIsDisabled() {
		empIdtxtbox.isEnabled();
	}

	public void ssnNoIsDisabled() {
		ssnNotxtbox.isEnabled();
	}

	public void sinIsDisabled() {
		sinNotxtbox.isEnabled();
	}

	public void driverLicenseIsDisabled() {
		drvrlcnsNotxtbox.isEnabled();
	}

	public void dobIsDisabled() {
		dobtxtbox.isEnabled();
	}

	public void firstNameisDisplayed() {
		firstnametxtbox.isDisplayed();
	}

	public void fillFirstName(String firstname) {
		firstnametxtbox.clear();
		firstnametxtbox.sendKeys(firstname);
	}

	public void fillMiddleName(String middlename) {
		middlenametxtbox.clear();
		middlenametxtbox.sendKeys(middlename);
	}

	public void fillLastName(String lastname) {
		lastnametxtbox.clear();
		lastnametxtbox.sendKeys(lastname);
	}

	public void clickSaveBtn() {
		savebtn.click();
	}

	public boolean verifyPersonalDetails(String frstname, String middname, String lstname) {
		String firstname = firstnametxtbox.getText();
		String midname = middlenametxtbox.getText();
		String lastname = lastnametxtbox.getText();
		boolean verify = firstname.equals(frstname) && midname.equals(middname) && lstname.equals(lastname);
		return verify;
	}
}
