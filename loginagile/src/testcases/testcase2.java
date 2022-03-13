package testcases;

import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.bouncycastle.openssl.EncryptionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import library.basetest;
import library.exceldata;
import pages.teamaddpage;
@Listeners(library.TestListener.class)
public class testcase2 extends basetest {
	public WebDriver driver;
	@BeforeMethod

	public void open() throws IOException, InterruptedException {
		driver =new ChromeDriver();
		driver.get("https://qa.agilityhealthradar.com/account/login");
		//teamaddpage teampage= new teamaddpage(driver,wc);
			
	}
	@DataProvider
	public Object [][] getlogindata() throws EncryptionException, IllegalFormatException, IOException, InvalidFormatException {
	
	exceldata ed= new exceldata();
	Object data [][]=ed.getdata("Sheet1");
	return data;
	}
	
	@Test(dataProvider="getlogindata")
	public void tc2(String Email,String Password) throws InterruptedException {
		teamaddpage teampage= new teamaddpage(driver, wc);
		
teampage.email(Email);
teampage.password(Password);
teampage.login();
	Thread.sleep(2000);
	teampage.team();
teampage.multeams();
Thread.sleep(2000);
//teampage.muladdteam();
Thread.sleep(2000);
teampage.addateam();
teampage.teamname("rrrr");
teampage.worktype();
Thread.sleep(2000);
teampage.wtkiosk();
Thread.sleep(2000);
teampage.create();
Thread.sleep(2000);
teampage.createstake();
Thread.sleep(2000);
teampage.review();
	}
	
	
	}
/*String Email=ed.getdata( xlpath,sheetname,1,0);

String Password=ed.getdata( xlpath,sheetname,1,1);
System.out.println(Email);
System.out.println(Password);*/
