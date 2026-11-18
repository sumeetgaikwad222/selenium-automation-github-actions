package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Browser_windows;

public class BrowserWindows_Test extends BaseClass{
	@Test
	public void checking()
	{
		Browser_windows bw = new Browser_windows(driver.get());
		bw.perform("New Window Message");
	}
}
