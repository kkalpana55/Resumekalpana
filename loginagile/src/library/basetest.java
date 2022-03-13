package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.opera.core.systems.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
//precondn
	
	public WebDriver driver,driver1;
	String browser;
	public webactionutils wc;
@Test

		public void openbrowserchrome() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 wc = new webactionutils(driver);
		driver.get("https://qa.agilityhealthradar.com/account/login");
		
		WebElement tooltiptext=driver.findElement(By.xpath("/html/body/header/div/div/div/a/img"));
		String tagname=tooltiptext.getTagName();
		System.out.println("The tag name is "+tagname);
		driver.manage().window().maximize();
		Reporter.log("open the Application");
		//driver1.get("https://qa.agilityhealthradar.com/account/login");
}

//@Test
//public void openbrowserie() throws Exception {
//		WebDriverManager.operadriver().setup();
//		driver1 = new OperaDriver();
//		driver1.get("https://qa.agilityhealthradar.com/account/login");
//		WebElement tooltiptext=driver1.findElement(By.xpath("/html/body/header/div/div/div/a/img"));
//		String tagname=tooltiptext.getTagName();
//		System.out.println("The tag name is "+tagname);
//		driver1.manage().window().maximize();
//		Reporter.log("open the Application");
//	}
//		
		//driver.close();
		//Reporter.log("close the browser");
		//driver1.close();
		
	//}
}
