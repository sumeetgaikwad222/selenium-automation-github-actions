package test;

import org.testng.annotations.Test;

import base.BaseClass;

public class Link_test extends BaseClass{
	
	@Test
	public void perform()
	{
		pages.Links ln = new pages.Links(driver);
		ln.check("created", "create");
	}

}
