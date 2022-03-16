package pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.basepage;
import library.webactionutils;

public class loginpage extends basepage {
	//class member
	@FindBy(id="Email")
	private WebElement email;
	@FindBy(id="Password")
	private WebElement password;
	@FindBy(xpath="//input[@class='btn login-btn']")
	private WebElement login;
	@FindBy(xpath="//*[@id='exportDropDown']/button/span")
	private WebElement export;
@FindBy(xpath="")
private WebElement excelexport;
//constructor
	public loginpage(WebDriver driver,webactionutils wc){
		super(driver,wc);
				}
	
	//member functions
	
	public void email(String ename) {
		wc.typeText(email,ename);
	//email.sendKeys(".............");
	}
	
public void password(String pname) {
		//password.sendKeys("......");
		wc.typeText(password,pname);
	}
public void login() {
	wc.clickOnElement(login);
	//login.click();
	
}
public void exports() {
	
	export.click();
	
}


public void excelexports() {
	 WebElement scanEle = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='exportDropDown-content']/button/span")));
	Actions action =new Actions(driver);
	action.moveToElement(scanEle).click().build().perform();
	String filePath = System.getProperty("user.home")+"/Downloads/teamList.xlsx";
	File f = new File(filePath);
	try {
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line!=null){
			System.out.println(line);
			line = br.readLine();
		}
		fr.close();
		br.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}}



