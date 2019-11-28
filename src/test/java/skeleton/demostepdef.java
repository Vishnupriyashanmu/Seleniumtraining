package skeleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class demostepdef {
	
	WebDriver driver;
	String ExpectedResult="Find a Flight: Mercury Tours:";
	
	@Given("^enduser is on the login page$")
	public void enduser_is_on_the_login_page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_c2a.05.01\\Desktop\\Selenium 3.0\\Selium 3.0\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demoaut.com");
	    
	}

	@When("^enduser enters the valid credentials and click on submit button$")
	public void enduser_enters_the_valid_credentials_and_click_on_submit_button() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleIs("Find a Flight: Mercury Tours:"));
	}

	@Then("^user does successful login$")
	public void user_does_successful_login() throws Throwable {
		Assert.assertEquals(ExpectedResult, driver.getTitle());
		if(driver.getTitle().equals(ExpectedResult)) {
		System.out.println("user does successful login"); }
	}

}
