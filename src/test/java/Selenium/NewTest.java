package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	String ExpectedResult="Find a Flight: Mercury Tours";  
    
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_c2a.05.01\\Desktop\\Selenium 3.0\\Selium 3.0\\chromedriver.exe");
	driver=new ChromeDriver();
	  
	 driver.get("http://demoaut.com");	 
  }

  @Test
  public void login() throws IOException {
	//driver.get("http://demoaut.com");
	  File src = new File("C:\\Temp\\Sel_data.xlsx");
      FileInputStream fis=new FileInputStream(src);
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet1=wb.getSheetAt(0);
      int i;
      
      for(i=0;i<=3;i++) {
    	  
      
   
      
      String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
      //System.out.println("First user name is:" +data0);
      
      String data1 = sheet1.getRow(i).getCell(1).getStringCellValue();
      //System.out.println("First password is:" +data1);
      
    
     driver.findElement(By.name("userName")).clear(); 
     driver.findElement(By.name("password")).clear(); 
	driver.findElement(By.name("userName")).sendKeys(data0);
	driver.findElement(By.name("password")).sendKeys(data1);
	driver.findElement(By.name("login")).click();
	//WebDriverWait wait=new WebDriverWait(driver,30);
	//wait.until(ExpectedConditions.titleIs("Find a Flight: Mercury Tours:"));
	
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	
		  
	 //System.out.println(driver.getTitle());
	if(driver.getTitle()==ExpectedResult) {sheet1.getRow(i).createCell(2).setCellValue("Pass");}
    else {sheet1.getRow(i).createCell(2).setCellValue("Fail");}
	FileOutputStream fo=new FileOutputStream(src);
	wb.write(fo);
	//Assert.assertEquals(ExpectedResult, driver.getTitle());
	
	//wb.close();
	driver.navigate().back();
      }
  }
  //sheet1.getRow(1).createCell(2).setCellValue("Pass");
  //sheet1.getRow(2).createCell(2).setCellValue("Fail");
  //sheet1.getRow(3).createCell(2).setCellValue("Fail"); 
  @AfterClass
  public void afterClass() {
	  
	 driver.close();
	  //driver.quit();
  }
}

  

