package library;

import java.util.ArrayList;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class webactionutils{
	public JavascriptExecutor js;
	public WebDriver driver;
	WebDriverWait wait;
	 webactionutils(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver,10);
	}
	public void waitTillPageLoad()
	{
	 ExpectedCondition<Boolean>jsload=webdiver->((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
	 boolean jsready =(Boolean)js.executeScript("return document.readyState").toString().equals("complete");
	 if(!jsready)
	 {
		System.out.println("Page is Loading....");
		wait.until(jsload);
	 }
	 else
	 {
		 loadPageAgain(2);
	 }
	}
	public void clickOnElement(WebElement element  )
	{    
	    if(((WebElement) wait.until(ExpectedConditions.elementToBeClickable(element))).isDisplayed())
	    {
	      System.out.println("Click On ");
		  element.click();	
	    }
	    else
	    {
	    	System.out.println(" is not visible or not clickable");
	       Assert.assertTrue(wait.until( ExpectedConditions.visibilityOf(element))==null);
	    }
    }
	
	public void loadPageAgain(long seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void typeText(WebElement element,String email2)
	{    
		if(((WebElement) wait.until(ExpectedConditions.elementToBeClickable(element))).isDisplayed())
		{
			System.out.println("Enter the value into ");
			element.sendKeys(email2);
		System.out.println("User is able to type "+email2+" into ");
		}
		else
		{
		Assert.fail("Unable to type on ");	
		}
	}
	
	public void typearrayText(WebElement element,String email2)
	{    
		if(((WebElement) wait.until(ExpectedConditions.elementToBeClickable(element))).isDisplayed())
		{
			System.out.println("Enter the value into ");
			element.sendKeys(email2);
		System.out.println("User is able to type "+email2+" into ");
		}
		else
		{
		Assert.fail("Unable to type on ");	
		}
	}
	
	public void waitForElement(WebElement element,String elementname)
	{
		if(((WebElement) wait.until(ExpectedConditions.visibilityOf(element))).isDisplayed())
		{
			System.out.println(elementname+" is Visible");
		}
		else
		{
			System.out.println(elementname+" is not visible or not clickable");
		    Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element))==null);
		}
	}
	public void refreshThePage()
	{
		driver.navigate().refresh();
		waitTillPageLoad();
		
	}
	
	public String getTheText(WebElement element,String elementname)
	{
		System.out.println("Getting the text :"+elementname);
		String eleText=null;
		if(element.isDisplayed())
		{
			eleText=element.getText();
		}
		else
		{
			System.out.println("Text is not Displayed/Loaded");
			Assert.fail("Unable to fetch the Text");
		}
		return eleText;
	}
	
	
	public String getThearraytext(WebElement element,ArrayList <String> elementname)
	{
		System.out.println("Getting the text :"+elementname);
		String eleText=null;
		if(element.isDisplayed())
		{
			eleText=element.getText();
		}
		else
		{
			System.out.println("Text is not Displayed/Loaded");
			Assert.fail("Unable to fetch the Text");
		}
		return eleText;
	}
	
	public void switchTotheFrame(WebElement frameElement)
	{
		waitTillPageLoad();
		System.out.println("Switching into the Frame ");
		driver.switchTo().frame(frameElement);
	}
	public void switchTotheFrame(int index)
	{
		waitTillPageLoad();
		System.out.println("Switching into the Frame ");
		driver.switchTo().frame(index);
	}
	
	
}
