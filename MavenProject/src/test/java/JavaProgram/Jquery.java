package JavaProgram;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Lists;

import utility.SeleniumUtility;

public class Jquery {

	public static void main(String[] args) {
		
		SeleniumUtility s1=new SeleniumUtility();
		WebDriver driver=s1.setUp("chrome", "https://jqueryui.com");
		//Actions act = new Actions(driver);
		WebElement element=driver.switchTo().activeElement();
		WebElement sortable=driver.findElement(By.xpath("//li[a[text()='Sortable']]"));
		sortable.click();
		//Step1: identify frame 
		WebElement frameObject=driver.findElement(By.cssSelector(".demo-frame"));
		//step2: switch your control from main page to frame
		driver.switchTo().frame(frameObject);
		//or instead of WebElement user index to switch
		//driver.switchTo().frame(0);

		Actions action=new Actions(driver);
		List<WebElement> option=driver.findElements(By.xpath("//ul[@id='sortable']//li"));
		//String i;
		//WebElement src=driver.findElement(By.xpath("//li[text()='Item 7']"));
		//WebElement target=driver.findElement(By.xpath("//li[text()='Item 1']"));
		// WebElement src = driver.findElement(By.xpath("//li[text()='Item " + option.size() + "']"));
		
		System.out.println("List of element are:"+option.size());
		for(int i=1;i<option.size()-1;i++) {
			{
				// WebElement dest =driver.findElement(By.xpath("//ul[@id='sortable']//li"));
				 WebElement dest = driver.findElement(By.xpath("//li[text()='Item " + i + "']"));
					
				// SeleniumUtility.action.clickAndHold(src).moveToElement(dest).dragAndDrop(src, dest).build().perform();
				   // Thread.sleep(1000);
				 //action.dragAndDrop(option.get(7), dest).build().perform();
				 action.dragAndDrop(option.get(6), dest).release().build().perform();
				 action.dragAndDrop(option.get(5), dest).release().build().perform();
				 action.dragAndDrop(option.get(4), dest).release().build().perform();
				 action.dragAndDrop(option.get(3), dest).release().build().perform();
				 action.dragAndDrop(option.get(2), dest).release().build().perform();
				 action.dragAndDrop(option.get(1), dest).release().build().perform();
				 action.dragAndDrop(option.get(0), dest).release().build().perform();
				 action.release();
			}
			
			
			
		//SeleniumUtility.action.dragAnDrop(option).perform();
		}
		
		
		driver.switchTo().defaultContent();
	}

}
