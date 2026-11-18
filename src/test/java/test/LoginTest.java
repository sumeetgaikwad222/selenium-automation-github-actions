package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	@Test
	public void loginTest() {
		LoginPage login = new LoginPage(driver.get());
		login.perform();
	}

}
