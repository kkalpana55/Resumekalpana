package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basepage {
	
	public WebDriver driver;
	public webactionutils wc;
	 public basepage(WebDriver driver,webactionutils wc) {
	 this.driver=driver;
		PageFactory.initElements(driver,this); 
		this.wc=wc;
	}
		 
}


