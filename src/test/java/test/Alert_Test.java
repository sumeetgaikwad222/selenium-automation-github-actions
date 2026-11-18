package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Alerts;
import pages.Browser_windows;

public class Alert_Test extends BaseClass{
	@Test
	public void checking()
	{
		Alerts al = new Alerts(driver.get());
		al.always();
		
		//al.onclickalert();
		//al.waitforsecalert();
		//al.acceptanddismissalert("dismiss");
		al.enterprompt(username);
	}
}
