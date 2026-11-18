package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.HorizontalScroll;

public class HorizontalScrollTest extends BaseClass{
	@Test
	public void checking()
	{
		HorizontalScroll sl = new HorizontalScroll(driver.get());
		sl.always();
	}

}
