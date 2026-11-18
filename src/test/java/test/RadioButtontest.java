package test;

import java.awt.Checkbox;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.CheckBox;

public class RadioButtontest extends BaseClass{
	@Test
	public void perform()
	{
		CheckBox ck = new CheckBox(driver.get());
		ck.checking("Impressive");
	}

}
