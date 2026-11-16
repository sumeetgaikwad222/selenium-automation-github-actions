package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Alerts;
import pages.Frames;

public class Frames_Test extends BaseClass{
	@Test
	public void checking()
	{
		Frames fr = new Frames(driver);
		fr.always();
		fr.frameone();
	}
}
