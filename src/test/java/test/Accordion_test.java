package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Accordion;

public class Accordion_test extends BaseClass{
	@Test
	public void perform()
	{
		Accordion ac = new Accordion(driver);
		ac.always();
		ac.check();
		ac.check1();
	}

}
