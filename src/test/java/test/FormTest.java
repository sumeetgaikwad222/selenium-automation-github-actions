package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Pratice_form;

public class FormTest extends BaseClass {
	@Test
    public void fillForm()
    {
        Pratice_form form = new Pratice_form(driver.get());
       form.perform1(username, email, "Male", "Music"); 		
    }

}
