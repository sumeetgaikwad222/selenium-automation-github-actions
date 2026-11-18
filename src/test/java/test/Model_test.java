package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Modal_Dialogs;
import pages.Nested_Frames;

public class Model_test extends BaseClass{
	@Test
	public void checking()
	{
		Modal_Dialogs md = new Modal_Dialogs(driver.get());
		md.always();
		md.check();
	}
}
