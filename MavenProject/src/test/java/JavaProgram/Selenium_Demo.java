package JavaProgram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Demo {

	public static void main(String[] args) {
		String dir=System.getProperty("user.dir");
		String executablePath=dir+"\\executable\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",executablePath);
	
		WebDriver cdriver=new ChromeDriver();
		cdriver.get("https://www.flipkart.com");
		//Application Title Validation
		String actualTitle=cdriver.getTitle();
		String expectedTitle="flipkart";
		System.out.println("Actual Result is:"+actualTitle);
		System.out.println("Expected Result is:"+expectedTitle);
		System.out.println("Validation Result is:"+actualTitle.equals(expectedTitle));
		
		//validation url
		String actualUrl=cdriver.getCurrentUrl();
		String expectedUrl="www.flipkart.com";
		System.out.println("Actual Result is:"+actualUrl);
		System.out.println("Expected Result is:"+expectedUrl);
		System.out.println("Validation Result is:"+actualUrl.contains(expectedUrl));
		//page source
		String pageSource=cdriver.getPageSource();
		System.out.println("Validation Result is:"+pageSource.length());
		
		//cdriver.close();
	}

}
/**
 * open chrome browser
 * get  google web page
 * following things possible
 * 1)validate current url
 * 2)validate page title
 * 3)get page source length
 */
