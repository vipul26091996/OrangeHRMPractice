package testfile;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseSetup;
import pagefile.LoginPageFile;
import pagefile.PersonalDetails;

public class TestFile extends BaseSetup {

	@Test
	public static void checkLoginFunctionality() throws IOException, InterruptedException {
		System.out.println("checkLoginFunctionality() method starts");
		SoftAssert sfassert = new SoftAssert();
		LoginPageFile loginpg_pagefile = new LoginPageFile(driver);
		loginpg_pagefile.navigateToUrl();
		loginpg_pagefile.enterUsername();
		loginpg_pagefile.enterPassword();
		loginpg_pagefile.clickLoginBtn();
		String actUrl = loginpg_pagefile.verifySuccessfulLogin();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		sfassert.assertEquals(actUrl, expUrl, "Login Unsuccessful");
		sfassert.assertAll();
		System.out.println("checkLoginFunctionality() method ends");

	}

	@Test(enabled = false)
	public static void checkUnsuccessfulLogin() throws IOException {
		System.out.println("checkUnsuccessfulLogin() method starts");
		SoftAssert sfassert = new SoftAssert();
		LoginPageFile loginpg_pagefile = new LoginPageFile(driver);
		loginpg_pagefile.navigateToUrl();
		loginpg_pagefile.enterUsername();
		loginpg_pagefile.enterInvalidPwd();
		loginpg_pagefile.clickLoginBtn();
		String actUrl = loginpg_pagefile.verifyLoginwithInvalidPwd();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		sfassert.assertEquals(actUrl, expUrl, "Login Successful");
		sfassert.assertAll();
		System.out.println("checkUnsuccessfulLogin() method ends");
	}

	@Test
	public static void checkPersonalDetailsField() {
		System.out.println("checkPersonalDetailsField() method starts");
		SoftAssert sfassert = new SoftAssert();
		PersonalDetails personaldetails_pagefile = new PersonalDetails(driver);
		personaldetails_pagefile.navigateToPersonalDetails();
		boolean verifyemp = personaldetails_pagefile.empIdIsDisabled();
		sfassert.assertEquals(verifyemp, false, "Employee ID field is enabled");
		boolean verifysin = personaldetails_pagefile.sinIsDisabled();
		sfassert.assertEquals(verifysin, false, "SIN No field is enabled");
		boolean verifyssnNo = personaldetails_pagefile.ssnNoIsDisabled();
		sfassert.assertEquals(verifyssnNo, false, "SSn No field is enabled");
		boolean verifydl = personaldetails_pagefile.driverLicenseIsDisabled();
		sfassert.assertEquals(verifydl, false, "Driver License No is enabled");
		boolean verifydob = personaldetails_pagefile.dobIsDisabled();
		sfassert.assertEquals(verifydob, false, "Date of Birth is enabled");
		sfassert.assertAll();
		System.out.println("checkPersonalDetailsField() method ends");
	}

	@Test
	public static void modifyName() throws InterruptedException {
		System.out.println("modifyName() method starts");
		SoftAssert sfassert = new SoftAssert();
		PersonalDetails personaldetails_pagefile = new PersonalDetails(driver);
		String firstname = "Vipul", midname = "Kumar", lastname = "Gola";
		Thread.sleep(5000);
		personaldetails_pagefile.clearFirstName();
		personaldetails_pagefile.fillFirstName(firstname);
		personaldetails_pagefile.clearMiddleName();
		personaldetails_pagefile.fillMiddleName(midname);
		personaldetails_pagefile.clearLastName();
		personaldetails_pagefile.fillLastName(lastname);
		personaldetails_pagefile.clickSaveBtn();
		boolean verify = personaldetails_pagefile.verifyPersonalDetails(firstname, midname, lastname);
		sfassert.assertEquals(verify, true, "Name is not updated");
		sfassert.assertAll();
		personaldetails_pagefile.checkNames(firstname, midname, lastname);
		System.out.println("modifyName() method ends");
	}
	
	@Test(enabled = false)
	public static void getList()
	{
		PersonalDetails personaldetails_pagefile = new PersonalDetails(driver);
		personaldetails_pagefile.getNames();
	}

}
