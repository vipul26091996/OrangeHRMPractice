package testfile;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseSetup;
import pagefile.LoginPageFile;

public class TestFile extends BaseSetup {

	@Test
	public static void checkLoginFunctionality() throws IOException {
		System.out.println("checkLoginFunctionality() method starts");
		SoftAssert sfassert = new SoftAssert();
		LoginPageFile loginpg_tesfile = new LoginPageFile(driver);
		loginpg_tesfile.navigateToUrl();
		loginpg_tesfile.enterUsername();
		loginpg_tesfile.enterPassword();
		loginpg_tesfile.clickLoginBtn();
		String actUrl = loginpg_tesfile.verifySuccessfulLogin();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		sfassert.assertEquals(actUrl, expUrl, "Login Unsuccessful");
		sfassert.assertAll();
		System.out.println("checkLoginFunctionality() method ends");
	}

	@Test
	public static void checkUnsuccessfulLogin() throws IOException {
		System.out.println("checkUnsuccessfulLogin() method starts");
		SoftAssert sfassert = new SoftAssert();
		LoginPageFile loginpg_testfile = new LoginPageFile(driver);
		loginpg_testfile.navigateToUrl();
		loginpg_testfile.enterUsername();
		loginpg_testfile.enterInvalidPwd();
		loginpg_testfile.clickLoginBtn();
		String actUrl = loginpg_testfile.verifyLoginwithInvalidPwd();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		sfassert.assertEquals(actUrl, expUrl, "Login Successful");
		sfassert.assertAll();
		System.out.println("checkUnsuccessfulLogin() method ends");
	}

}
