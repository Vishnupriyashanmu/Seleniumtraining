package LibraryFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserFactory {
	
	static WebDriver driver;
	public static WebDriver startBrowser (String browsername,String url) {
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_c2a.05.01\\Desktop\\Selenium 3.0\\Selium 3.0\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		}
		
	}


