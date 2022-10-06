package Assignment15;

import org.testng.annotations.Test;

import utility.SeleniumUtility;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
@Test

public class VtigerTestng extends SeleniumUtility {
 
  @BeforeTest
  public void loginvtiger() {
	  SeleniumUtility s1=new SeleniumUtility();
	  WebDriver driver=s1.setUp("chrome","https://demo.vtiger.com/vtigercrm/index.php");
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("Test@123",Keys.ENTER);
		
  }
  @Test(priority=1)
  public void menu() {
	  WebElement menu=driver.findElement(By.xpath("//div[@class='row']/div/div/div[@id='appnavigator']/div[@class='row app-navigator']/span"));
	  menu.click();
	  Actions act=new Actions(driver);
	  driver.findElement(By.xpath("//div[@class='menu-items-wrapper app-menu-items-wrapper']/span[text()=' MARKETING']/following::span")).click();
	  driver.findElement(By.xpath("//ul/div[@id='mCSB_1']/div/li[2]/a")).click();
 
  }

  @Test(priority=2)
  public void leads() {  
	  driver.findElement(By.xpath("//ul/li/button[@type='button']")).click();
	  driver.findElement(By.xpath("//table/tbody/tr/td[1]/following::td/div/a/span[text()='None']/following::span/b")).click();
  }
  @AfterTest
  public void afterTest() {
  }

}
