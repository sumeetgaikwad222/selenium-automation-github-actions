package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Dynamicbutton;

public class DynamicButtonTest  extends BaseClass{
	
	@Test
	public void perform()
	{
		Dynamicbutton dy = new Dynamicbutton(driver.get());
		dy.check();
	}

}
