package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Calender;

public class Calender_Test extends BaseClass{
	@Test
	public void perform()
	{
		Calender cl = new Calender(driver.get());
		cl.always();
		cl.check(
		        "June",
		        "2026",
		        "26");
		cl.selectDateAndTime("June", "2026", "27");
	}
}
