package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Slider;

public class ScrollUpTest extends BaseClass{
	@Test
	public void checking()
	{
		ScrollUp sl = new ScrollUp(driver.get());
		sl.always();
	}

}
