package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Slider;

public class Slider_Test extends BaseClass{
	@Test
	public void checking()
	{
		Slider sl = new Slider(driver.get());
		sl.always();
		sl.setSliderValue(68);
	}
}
