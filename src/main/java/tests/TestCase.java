package tests;

import org.testng.annotations.BeforeMethod;

import common.TestBase;
import org.testng.annotations.Parameters;
import pages.Page;

public class TestCase {
	public TestBase testBase = new TestBase();

	@Parameters({ "url", "ChromeBrowser" })
	@BeforeMethod
	public void openBrowser(String url, String browser) {

		testBase.openSingerBrowser(url, browser);
	}

}
