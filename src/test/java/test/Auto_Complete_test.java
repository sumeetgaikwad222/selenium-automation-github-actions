package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Accordion;
import pages.Auto_Complete;

public class Auto_Complete_test extends BaseClass{
	@Test
	public void perform()
	{
		Auto_Complete at = new Auto_Complete(driver.get());
		at.always();
		at.check("JavaScript");
		
	}

}
