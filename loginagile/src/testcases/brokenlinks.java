package testcases;

import java.awt.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import library.basetest;
import pages.loginpage;
@Test
public class brokenlinks extends basetest {
	public void testcase11() {
		String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;	
        String homePage = "https://qa.agilityhealthradar.com/account/login";
	
	loginpage lp = new loginpage(driver,wc );
java.util.List<WebElement>  links =  driver.findElements(By.tagName("a"));
java.util.Iterator<WebElement> it = links.iterator();
while(it.hasNext()){
    
    url = it.next().getAttribute("href");
    
    System.out.println(url);

    if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
        continue;
    }
    
    if(!url.startsWith(homePage)){
        System.out.println("URL belongs to another domain, skipping it.");
        continue;
    }
    
    try {
        huc = (HttpURLConnection)(new URL(url).openConnection());
        
        huc.setRequestMethod("HEAD");
        
        huc.connect();
        
        respCode = huc.getResponseCode();
        
        if(respCode >= 400){
            System.out.println(url+" is a broken link");
        }
        else{
            System.out.println(url+" is a valid link");
        }
            
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
	}
	}
	
}
