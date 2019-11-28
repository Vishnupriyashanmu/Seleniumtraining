package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import LibraryFunctions.browserFactory;
import Pages.login;

public class logintestcase {
	
	@Test
	public void test()
	{
		WebDriver driver=browserFactory.startBrowser("chrome", "http://demoaut.com/");
		login log = new login(driver);
		log.loginuser("tutorial", "tutorial");
		
	}

}
