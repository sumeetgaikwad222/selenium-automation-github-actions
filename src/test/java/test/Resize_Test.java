package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Resize;

public class Resize_Test extends BaseClass{
	@Test
	public void checking()
	{
		Resize rz = new Resize(driver.get());
		rz.always();
		rz.check();
	}

}
