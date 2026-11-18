package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Droppable;

public class Droppable_Test extends BaseClass{
	@Test
	public void checking()
	{
		Droppable dp = new Droppable(driver.get());
		dp.always();
		dp.check();
	}
}
