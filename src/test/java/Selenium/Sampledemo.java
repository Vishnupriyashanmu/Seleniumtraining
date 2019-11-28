package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sampledemo {

	public static void main(String[] args) throws IOException {
	
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_c2a.05.01\\Desktop\\Selenium 3.0\\Selium 3.0\\chromedriver.exe");
       // WebDriver driver=new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        
        File src = new File("C:\\Temp\\Sel_data.xlsx");
        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1=wb.getSheetAt(0);
        
        String data0 = sheet1.getRow(1).getCell(0).getStringCellValue();
        System.out.println("First user name is:" +data0);
        
        String data1 = sheet1.getRow(2).getCell(1).getStringCellValue();
        System.out.println("First password is:" +data1);
        
        wb.close();
        int i;
        int j;
        
        
        
        
	}

}
