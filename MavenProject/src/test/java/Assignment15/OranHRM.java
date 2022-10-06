package Assignment15;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.SeleniumUtility;

public class OranHRM {

	public static void main(String[] args) {
		SeleniumUtility s1=new SeleniumUtility();
		
		
		WebDriver driver=s1.setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123",Keys.ENTER);
		WebElement pim=driver.findElement(By.cssSelector("div.oxd-sidepanel-body>ul>li:nth-of-type(2)>a>span"));

		driver.findElement(By.cssSelector("div>button>i.oxd-icon.bi-plus.oxd-button-icon")).click();
		driver.findElement(By.name("firstName")).sendKeys("peter");
		driver.findElement(By.name("middleName")).sendKeys("nick");
		driver.findElement(By.name("lastName")).sendKeys("john",Keys.TAB,Keys.ENTER);
		WebDriverWait wait=new WebDriverWait(driver,50);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-employee-form']/div/div[2]")));
		//driver.findElement(By.xpath("//div[@class='orangehrm-employee-form']/div/div[2]")).sendKeys("3434");
		driver.findElement(By.cssSelector("div.oxd-form-actions>*:nth-child(3)")).submit();
		Actions act=new Actions(driver);		
		//edit profile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Nickname']/following::input[1]")));
		
		driver.findElement(By.xpath("//label[text()='Nickname']/following::input[1]")).sendKeys("pop");;
		
		WebElement id=driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]"));
		act.moveToElement(id).doubleClick().keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		id.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='oxd-form-actions']/p/following::button[@type='submit'][1]")).submit();
		
		//search profile
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-sidepanel-body>ul>li:nth-of-type(2)>a>span")));
		driver.findElement(By.cssSelector("div.oxd-sidepanel-body>ul>li:nth-of-type(2)>a>span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Name']/following::input[1]")));
		driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Name']/following::input[1]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Id']/following::input[1]")));
		driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div[1]/label[text()='Employee Id']/following::input[1]")).sendKeys(Keys.chord(Keys.CONTROL,"v",Keys.ENTER));;
		//act.moveToElement(unid).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		//unid.sendKeys(Keys.ENTER);
		
		
		//page down
		WebElement body=driver.findElement(By.xpath("//body/div/div/div[2]/div[2]/div"));
		act.moveToElement(body).clickAndHold().sendKeys(Keys.PAGE_DOWN).build().perform();
		
		//checkbox
		WebElement selectCheckbox=driver.findElement(By.xpath("//div[@class='oxd-table-card-cell-checkbox']/div/label/input/following::span/i"));
		//String Checkbox=selectCheckbox.getText();
		act.moveToElement(selectCheckbox).click().build().perform();
		boolean result=selectCheckbox.isSelected();
		System.out.println(result==false);
		WebElement delete=driver.findElement(By.xpath("//button[@type='button']/i[@class='oxd-icon bi-trash']"));
		act.moveToElement(delete).click().build().perform();
		
		WebElement popup=driver.findElement(By.xpath("//div[@role='document']/div[3]/button[2]/i"));
		
		act.moveToElement(popup).click().build().perform();
		
		//job
//		driver.findElement(By.xpath("//div[@class='orangehrm-tabs']/div[6]/a")).click();
//		List<WebElement> options=driver.findElements(By.xpath("//div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[2]/div/div[2]/div/div/div[text()='-- Select --']/following::i[1]"));
//		System.out.println("option count: "+options.size());
//		//use for loop to print one by one option
//		for(int i=0;i<options.size();i++) {
//			System.out.println(options.get(i).getText());
//		}
		//options.get(2).click();
		
		
		
		//WebElement save=driver.switchTo().activeElement();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='License Expiry Date']/following::input[1]")));
		//WebElement date=driver.switchTo().activeElement();
		//driver.findElement(By.xpath("//label[text()='License Expiry Date']/following::input[1]")).sendKeys("2022-11-17");
			
		
		
		
	
		}

}
