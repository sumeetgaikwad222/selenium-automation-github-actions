package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Frames;
import pages.Nested_Frames;

public class NestedFrames_Test extends BaseClass{
	@Test
	public void checking()
	{
		Nested_Frames nf = new Nested_Frames(driver.get());
		nf.always();
		nf.check();
	}
}
