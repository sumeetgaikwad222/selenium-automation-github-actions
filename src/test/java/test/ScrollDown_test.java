package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Scrolldown;

public class ScrollDown_test extends BaseClass{
	@Test
	public void checking()
	{
		Scrolldown sd = new Scrolldown(driver.get());
		sd.always();
	}
}
