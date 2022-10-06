package JavaProgram;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CricinInfo {

	public static void main(String[] args) {
		String CurrentWorkingDir=System.getProperty("user.dir");
		String Systempath=CurrentWorkingDir+"\\executable\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Systempath);
		
		
		WebDriver cd=new ChromeDriver();
		//cd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		cd.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		cd.get("http:\\www.cricinfo.com");
		cd.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(cd,30);
		String homePageUrl=cd.getCurrentUrl();
		System.out.println("Home validation status: "+homePageUrl.contains("cricinfo"));
		List <WebElement> cMenu=cd.findElements(By.cssSelector("div.ds-bg-fill-navbar>div:nth-child(1)>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)>div.ds-popper-wrapper"));
		System.out.println("cMenu is:"+cMenu.size());
		for (int i = 0; i < cMenu.size(); i++) {
			// to avoid stale element exception re-identify the required element like below, if you are not using fluent wait
			// sugg=driver.findElements(By.cssSelector("ul>li>div>div:nth-of-type(2)>*:first-child>span"));  
			WebElement element = cMenu.get(i);
			System.out.println(element.getText());
	}

}
}
