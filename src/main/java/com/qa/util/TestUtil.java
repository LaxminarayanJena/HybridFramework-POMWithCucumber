package com.qa.util;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=90;
	public static long IMPLICIT_WAIT=60;

	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

}

