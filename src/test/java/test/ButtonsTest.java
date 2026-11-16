package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Buttons;

public class ButtonsTest extends BaseClass{
	@Test
	public void perform() {
		Buttons bt = new Buttons(driver);
		bt.check();
	}

}
