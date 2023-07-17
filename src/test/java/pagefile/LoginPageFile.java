package pagefile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFile {

	public static WebDriver driver;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login_btn;

	@FindBy(xpath = "//p[text()='Invalid credentials']")
	WebElement invalidpwdtext;

	static FileReader fr;
	static Properties prop = new Properties();

	public LoginPageFile(WebDriver driver) throws IOException {
		LoginPageFile.driver = driver;
		PageFactory.initElements(driver, this);
		fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/testdata/login_data.properties");
		prop.load(fr);

	}

	public void navigateToUrl() {
		driver.get(prop.getProperty("login_url"));
	}

	public void enterUsername() {
		username.sendKeys(prop.getProperty("username"));
	}

	public void enterPassword() {
		password.sendKeys(prop.getProperty("password"));
	}

	public void enterInvalidPwd() {
		password.sendKeys(prop.getProperty("invalidpwd"));
	}

	public void clickLoginBtn() {
		login_btn.click();
	}

	public String verifySuccessfulLogin() {
		String actUrl = driver.getCurrentUrl();
		return actUrl;
	}

	public String verifyLoginwithInvalidPwd() {
		String actUrl = driver.getCurrentUrl();
		System.out.println(invalidpwdtext.getText());
		return actUrl;
	}
}
