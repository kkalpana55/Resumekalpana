package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.basetest;
import pages.exportteampage;
import pages.loginpage;

public class paralleltesting  extends basetest
{
	@Test
	public void tc5() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException {
		
		loginpage lp=new loginpage(driver,wc);
		lp.email("companyadmin@agilityhealthradar.com");
		lp.password("temp1234");
		lp.login();
		Reporter.log("Agile Login Page");
		lp.exports();
		Thread.sleep(2000);
		lp.excelexports();
		Thread.sleep(2000);
				
		/*loginpage lp1=new loginpage(driver1,wc);
		lp1.email("companyadmin@agilityhealthradar.com");
		lp1.password("temp1234");
		lp1.login();
		Reporter.log("Agile Login Page");		
		lp1.exports();
		Thread.sleep(2000);
		lp1.excelexports();
		Thread.sleep(2000);*/
		
	}

}
