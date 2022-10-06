package JavaProgram;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DateUtility;
import utility.SeleniumUtility;

public class ScreenShot{

public static void main(String[] args) throws IOException  {
		SeleniumUtility s1 = new SeleniumUtility();

		WebDriver driver = s1.setUp("chrome", "https://www.google.com");
		//setup chrome new version
		//WebDriverManager.chromedriver().setup();
	//WebDriver driver=new ChromeDriver();
	//driver.get("https://www.google.com");
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		
//		File screenShot=ts.getScreenshotAs(OutputType.FILE);
//		
//		FileUtils.copyFile(screenShot, new File(".\\src\\test\\resources\\screenshots\\GoogleSearchPage.png"));
					//or
		
		String date=DateUtility.getRequiredDateBasedOnNumberOfDays("ddMMyyyyHHmmss", 0);
		String fileName=".\\src\\test\\resources\\screenshot\\screengoogle"+date+".png";
		s1.takeScreenshot(fileName);
	}

}