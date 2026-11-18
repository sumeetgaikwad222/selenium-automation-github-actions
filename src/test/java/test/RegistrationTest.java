package test;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Registration;

public class RegistrationTest extends BaseClass {
	
	@Test
	public void registrationTest() throws IOException {
		Registration reg = new Registration(driver.get());
		reg.perform("sathish", "kumar", "sathishkumar", "sathish", "2");
	}
}
