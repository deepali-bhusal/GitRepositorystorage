package JavaProgram;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.SeleniumUtility;

public class ErailWindow {

	public static void main(String[] args) {
		SeleniumUtility s1 = new SeleniumUtility();
		WebDriver driver = s1.setUp("chrome", " https://erail.in/");

		// get current window unique id
		String homePageWinId = driver.getWindowHandle();// T1
		System.out.println("Home page window ID: " + homePageWinId);

		// performing click operation to open ecatering page in new tab
		driver.findElement(By.xpath("//a[text()='eCatering']")).click();

		// get all windows unique IDs which are opened by selenium current instance
		Set<String> allWinIds = driver.getWindowHandles();
		// s1.waitTillElementIsClickable(allWinIds);
		System.out.println("All windows ID: " + allWinIds);// T1,T2
		allWinIds.remove(homePageWinId);// T2
		System.out.println("After remoing homeWinID, all windows ID: " + allWinIds);
		// get child window id using iterator
		Iterator<String> itr = allWinIds.iterator();
		String childWinId = itr.next();
		driver.switchTo().window(childWinId);
		// now you are allow to identify any element from child window
		System.out.println("eCatering page title: " + driver.getTitle());
		System.out.println("eCatering page ulr: " + driver.getCurrentUrl());

		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Train or Station to explore']"));
		search.click();
		String str = search.getAttribute("placeholder");
		System.out.println(str);
		WebElement target = driver.findElement(By.xpath("//input[@placeholder='Start typing Nagpur, NGP, Rajdhani']"));
		String str1 = target.getAttribute("placeholder");
		System.out.println(str1);
		s1.waitTillElementIsClickable(target);
		target.sendKeys("12627");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		// driver.findElement(By.xpath("//button[text()='KARNATAKA EXP']")).click();
		WebElement select = driver.findElement(By.xpath("//button[text()='KARNATAKA EXP']"));
//		String str2=select.getText();
//		System.out.println("Select Express:"+str2);
		select.click();
		// s1.waitTillElementIsClickable(select);
		act.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//input[@name='date']")).click();
		act.sendKeys("2022-10-16", Keys.ENTER).build().perform();

		act.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//select[@placeholder='Boarding Station']//option[3]")).click();

		act.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//button[text()='FIND FOOD']"));
		act.sendKeys(Keys.ENTER).build().perform();

		List<WebElement> nameRest = driver
				.findElements(By.xpath("//div[h4[span[text()='Restaurants at']]]//div[2]/div[1]/h5"));
		System.out.println("Main Menu option count: " + nameRest.size());
		for (int i = 0; i < nameRest.size(); i++) {
			WebElement option = nameRest.get(i);
			act.moveToElement(option).perform();
			System.out.println("Option " + i + ": " + option.getText());
			// Thread.sleep(1000);
			//driver.switchTo().window(homePageWinId);
			// now you are allow to identify any element from home window
//			System.out.println("etrain page title: " + driver.getTitle());
//			System.out.println("etrain page ulr: " + driver.getCurrentUrl());
			// close current instance of browser
			// driver.close();
		}
	}// select[@placeholder='Boarding Station']//option[4]

}
