package JavaProgram;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String currentWorkingDir=System.getProperty("user.dir");
		String CurrentPath=currentWorkingDir+"\\executable\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", CurrentPath);
		WebDriver cdriver =new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		cdriver.get("https://opensource-demo.orangehrmlive.com/");
		WebDriverWait wait=new WebDriverWait(cdriver,20);
		System.out.println("**********Page Title and Title Length*********");
		String actualTitle=cdriver.getTitle();
		String expectedTitle="orangehrmlive";
		System.out.println("Actual Result is:"+actualTitle);
		System.out.println("Expected Result is:"+expectedTitle);
		System.out.println("Validation Result is:"+actualTitle.equals(expectedTitle));
		System.out.println("page Title Length is:"+actualTitle.length());
		System.out.println("**********Get URL*********");
		String actualUrl=cdriver.getCurrentUrl();
		String expectedUrl="//opensource-demo.orangehrmlive.com/";
		System.out.println("Actual Result is:"+actualUrl);
		System.out.println("Expected Result is:"+expectedUrl);
		System.out.println("Validation Result is:"+actualUrl.contains(expectedUrl));
		
		System.out.println("*****************validation username,password and login button*************");
		WebElement username=cdriver.findElement(By.name("username"));
		
		username.clear();
		username.sendKeys("Admin");
		WebElement pwd=cdriver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys("admin123");
		WebElement submitBtn=cdriver.findElement(By.className("orangehrm-login-button"));
		submitBtn.click();
		String homePageUrl=cdriver.getCurrentUrl();
		System.out.println("Home validation status: "+homePageUrl.contains("viewEmployeeList"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-userdropdown-link")));
		System.out.println("Home page title: "+cdriver.getTitle());	
		WebElement logout=cdriver.findElement(By.className("oxd-userdropdown-link"));
		logout.click();
		//cdriver.close();
	}


	}


