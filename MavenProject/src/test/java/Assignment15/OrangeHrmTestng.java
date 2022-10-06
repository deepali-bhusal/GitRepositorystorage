package Assignment15;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import utility.SeleniumUtility;

@Test
public class OrangeHrmTestng  extends SeleniumUtility  {
	SeleniumUtility s1=new SeleniumUtility();
	//Actions act=new Actions(driver);
@BeforeTest
  public void beforeTest() {
	
		WebDriver driver=s1.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
  }

@Test(priority=1)
public void login() {
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123",Keys.ENTER);
	}
@Test(priority=2)
public void pim() {
	driver.findElement(By.cssSelector("div>button>i.oxd-icon.bi-plus.oxd-button-icon")).click();
	driver.findElement(By.name("firstName")).sendKeys("nick");
	driver.findElement(By.name("middleName")).sendKeys("jones");
	WebElement id=driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Id']/following::input[1]"));
	
	driver.findElement(By.name("lastName")).sendKeys("peter",Keys.TAB,Keys.ENTER);
}
@Test(priority=3)
public void dynamicTable() {
	driver.findElement(By.cssSelector("div.oxd-sidepanel-body>ul>li:nth-of-type(2)>a>span")).click();
	Actions action=new Actions(driver);
WebElement body=driver.findElement(By.xpath("//body/div/div/div[2]/div[2]/div"));
	action.moveToElement(body).clickAndHold().sendKeys(Keys.PAGE_DOWN).build().perform();
	WebElement checkboxclick=driver.findElement(By.xpath("//div[@class='orangehrm-container']/div/div[2]/div[3]/div/div/div/div/label/input[@type='checkbox']/following::i[1]//following::div/div[contains(text(),'0256')]"));
	checkboxclick.click();
}
	
@Test(priority=4)
public void editprofile() {
	Actions act=new Actions(driver);
	driver.findElement(By.xpath("//label[text()='Nickname']/following::input[1]")).sendKeys("Nick");;
	
	WebElement id=driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]"));
	act.moveToElement(id).doubleClick().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
	id.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//div[@class='oxd-form-actions']/p/following::button[@type='submit'][1]")).submit();
	}
@Test(priority=5)
public void searchProfile() {
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-sidepanel-body>ul>li:nth-of-type(2)>a>span")));
	driver.findElement(By.cssSelector("div.oxd-sidepanel-body>ul>li:nth-of-type(2)>a>span")).click();
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Name']/following::input[1]")));
	driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Name']/following::input[1]"));
	
	driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Id']/following::input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"v",Keys.ENTER));;

}
@Test(priority=6)

public void pageDown() {
	Actions action=new Actions(driver);
	WebElement body=driver.findElement(By.xpath("//body/div/div/div[2]/div[2]/div"));
	action.moveToElement(body).clickAndHold().sendKeys(Keys.PAGE_DOWN).build().perform();
}
@Test(priority=7)
public void checkBox() {
	Actions ac=new Actions(driver);
	WebElement selectCheckbox=driver.findElement(By.xpath("//div[@class='oxd-table-card-cell-checkbox']/div/label/input/following::span/i"));
	//String Checkbox=selectCheckbox.getText();
	ac.moveToElement(selectCheckbox).click().build().perform();
	boolean result=selectCheckbox.isSelected();
	System.out.println(result==false);
	WebElement delete=driver.findElement(By.xpath("//button[@type='button']/i[@class='oxd-icon bi-trash']"));
	ac.moveToElement(delete).click().build().perform();
	
	WebElement popup=driver.findElement(By.xpath("//div[@role='document']/div[3]/button[2]/i"));
	
	ac.moveToElement(popup).click().build().perform();
	
	
}


@AfterTest
  public void afterTest() {
	 //s1.tearDown();
  }

}

