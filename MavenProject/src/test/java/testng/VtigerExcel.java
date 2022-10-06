package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ExcelUtility;
import utility.SeleniumUtility;

@Test
public class VtigerExcel  extends SeleniumUtility {
			String appUrl;
			String userName;
			String password;
			String result;
			
			@BeforeTest
			public void getData() {
				appUrl=ExcelUtility.getCellValue(".\\src\\test\\resources\\TestData\\AppTestData.xlsx", "sheet2", 2, 1);
				userName=ExcelUtility.getCellValue(".\\src\\test\\resources\\TestData\\AppTestData.xlsx", "sheet2", 2, 2);
				password=ExcelUtility.getCellValue(".\\src\\test\\resources\\TestData\\AppTestData.xlsx", "sheet2", 2, 3);
				
			}
			@Test
			public void Vtigerlogin() {
				//Action act=new Actions();
					WebDriver driver=setUp("chrome", appUrl);	
					driver.findElement(By.id("username")).clear();
					driver.findElement(By.id("username")).sendKeys(userName);
					driver.findElement(By.id("password")).clear();
					driver.findElement(By.name("password")).sendKeys(password,Keys.ENTER);
				//	driver.findElement(By.name("password")).submit();
				//driver.findElement(By.tagName("button")).submit();
					
					
					
					boolean validationRes=getpageTitlepage("Dashboard").equals("Dashboard");
					if(validationRes) {
						result="Passed";
						ExcelUtility.updateCellValue(".\\src\\test\\resources\\TestData\\AppTestData.xlsx", "sheet2", 2, 5,"Dashboard");
					}else {
						result="Failed";
						ExcelUtility.updateCellValue(".\\src\\test\\resources\\TestData\\AppTestData.xlsx", "sheet2", 2, 5,"failed");
					}

				Assert.assertTrue(validationRes, "Login page validation failed");	
				
					
			}
			@AfterTest
			public void cleanUp() 
			{
				ExcelUtility.updateCellValue(".\\src\\test\\resources\\TestData\\AppTestData.xlsx", "sheet2", 2, 6,result);
				
				
				//tearDown();
			}
		
			
	}

	

