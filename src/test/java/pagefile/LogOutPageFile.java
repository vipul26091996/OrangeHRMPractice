package pagefile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPageFile {

	@FindBy(xpath = "//i[contains(@class,'userdropdown')]")
	WebElement profile;

	@FindBy(xpath = "//a[(text()='Logout')]")
	WebElement logout;

	public void clickOnProfile() {
		profile.click();
	}

	public void clickOnLogOut() {
		logout.click();
	}

}
