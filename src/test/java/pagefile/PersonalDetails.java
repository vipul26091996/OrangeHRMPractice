package pagefile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstnametxtbox;

	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middlenametxtbox;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastnametxtbox;

	@FindBy(xpath = "//form[@class='oxd-form'][1]/div[5]/button")
	WebElement savebtn;

	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pim;

	@FindBy(xpath = "//div[3]/div/div[2]/div[2]")
	WebElement tablecell;

	@FindBy(xpath = "//div[contains(@class,'employee-name')]/h6")
	WebElement updatedname;

	@FindBy(xpath = "//div[3]/div/div[2]/div/div/div[3]")
	List<WebElement> firstmidnamelist;

	@FindBy(xpath = "//div[3]/div/div[2]/div/div/div[4]")
	List<WebElement> lastnamelist;

	@FindBy(xpath = "//i[contains(@class,'chevron-right')]//parent::button")
	WebElement navigatetonextlist;

	public PersonalDetails(WebDriver driver) {
		PersonalDetails.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean empIdIsDisabled() {
		boolean verify = empIdtxtbox.isEnabled();
		System.out.println(verify);
		return verify;
	}

	public boolean ssnNoIsDisabled() {
		boolean verify = ssnNotxtbox.isEnabled();
		System.out.println(verify);
		return verify;
	}

	public boolean sinIsDisabled() {
		boolean verify = sinNotxtbox.isEnabled();
		System.out.println(verify);
		return verify;
	}

	public boolean driverLicenseIsDisabled() {
		boolean verify = drvrlcnsNotxtbox.isEnabled();
		System.out.println(verify);
		return verify;
	}

	public boolean dobIsDisabled() {
		boolean verify = dobtxtbox.isEnabled();
		System.out.println(verify);
		return verify;
	}

	public boolean firstNameisDisplayed() {
		boolean verify = firstnametxtbox.isDisplayed();
		System.out.println(verify);
		return verify;
	}

	public void clearFirstName() {
		firstnametxtbox.click();
		Actions actions = new Actions(driver);
		actions.keyDown(firstnametxtbox, Keys.CONTROL).sendKeys("a").perform();
		firstnametxtbox.sendKeys(Keys.DELETE);

	}

	public void clearMiddleName() {
		middlenametxtbox.click();
		Actions actions = new Actions(driver);
		actions.keyDown(middlenametxtbox, Keys.CONTROL).sendKeys("a").perform();
		middlenametxtbox.sendKeys(Keys.DELETE);
	}

	public void clearLastName() {
		lastnametxtbox.click();
		Actions actions = new Actions(driver);
		actions.keyDown(lastnametxtbox, Keys.CONTROL).sendKeys("a").perform();
		lastnametxtbox.sendKeys(Keys.DELETE);
	}

	public void fillFirstName(String firstname) {
		firstnametxtbox.sendKeys(firstname);
	}

	public void fillMiddleName(String middlename) {
		middlenametxtbox.sendKeys(middlename);
	}

	public void fillLastName(String lastname) {
		lastnametxtbox.sendKeys(lastname);
	}

	public void clickSaveBtn() {
		savebtn.click();
	}

	public boolean verifyPersonalDetails(String frstname, String middname, String lstname) throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		String updated_name = updatedname.getText();
		System.out.println("New name=" + updated_name);
		System.out.println((frstname + " " + lstname));
		if ((frstname + " " + lstname).equals(updated_name)) {
			return true;
		} else {
			return false;
		}
	}

	public void navigateToPersonalDetails() {
		pim.click();
		tablecell.click();
	}

	public void getNames() {
		pim.click();
		System.out.println("size = " + firstmidnamelist.size());
		for (int i = 1; i <= firstmidnamelist.size(); i++) {
			System.out.println("First and Mid name = "
					+ driver.findElement(By.xpath("//div[3]/div/div[2]/div[" + i + "]/div/div[3]")).getText());
			System.out.println("Last name = "
					+ driver.findElement(By.xpath("//div[3]/div/div[2]/div[" + i + "]/div/div[4]")).getText());
		}
	}

	public void checkNames(String firstname, String midname, String lstname) {
		pim.click();
		int count = 0, end = 0;
		System.out.println("firstmidnamelist size " + firstmidnamelist.size());

		do {
			for (int i = 1; i <= firstmidnamelist.size(); i++) {
				System.out.println("firstmidnamelist size " + i + " = a" + firstmidnamelist.size());
				String firstmidname = driver.findElement(By.xpath("//div[3]/div/div[2]/div[" + i + "]/div/div[3]"))
						.getText();
				String lastname = driver.findElement(By.xpath("//div[3]/div/div[2]/div[" + i + "]/div/div[4]"))
						.getText();
				System.out.println(firstmidname + " " + lastname);
				if ((firstmidname + " " + lastname).equals(firstname + " " + midname + " " + lstname)) {
					count++;
					break;
				}
				if (navigatetonextlist.isDisplayed() == false) {
					end++;
					break;
				}

			}
			if (count == 0) {
				navigatetonextlist.click();
			}
		} while (end == 0);

		System.out.println("do while loop");
		System.out.println(navigatetonextlist.isDisplayed());

		if (count == 0) {
			System.out.println("Name not displaying in list");
		} else {
			System.out.println("Name is displaying in the list");
		}
	}
}
