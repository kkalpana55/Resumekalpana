package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.basetest;
import pages.exportteampage;

public class exceltestcase extends basetest {
	@Test
	public void tc3() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException  {
		
		exportteampage ex=new exportteampage(driver,wc);
		//String downloadPath = "C:\\Users\\User\\Downloads";
		ex.email("kkalpana55@gmail.com");
		ex.password("temp1234");
		ex.login();
		ex.exports();
		Thread.sleep(2000);
		ex.excelexports();
		Thread.sleep(2000);
		}

	

}
