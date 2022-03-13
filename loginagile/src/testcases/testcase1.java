package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import library.basetest;
import library.webactionutils;
import pages.exportteampage;
import pages.loginpage;

public class testcase1 extends basetest{
	@Test
	public void tc1() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException {
		
		exportteampage lp=new exportteampage(driver,wc);
		lp.email("kkalpana55@gmail.com");
		lp.password("temp1234");
		lp.login();
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");	
		Reporter.log("Agile Login Page");
		lp.exports();
		Thread.sleep(2000);
		lp.excelexports();
		Thread.sleep(2000);
	
	
	}
	
	
	
	
	

}
