package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.basepage;
import library.webactionutils;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class teamaddpage extends basepage {
public teamaddpage(WebDriver driver,webactionutils wc){
		super(driver,wc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
			}

@FindBy(id="Email")
private WebElement email;
@FindBy(id="Password")
private WebElement password;
@FindBy(xpath="//input[@class='btn login-btn']")
private WebElement login;
@FindBy(xpath="//span[@class='btn ah-green-btn-lg fl-rt add_team_btn active_class']")
private WebElement team;
@FindBy(xpath="//input[@id='multiteam_btn']")
private WebElement multeam;
//@FindBy(xpath="//span[@id='go']")
//private WebElement teamadd;
@FindBy(xpath="//span[@class='btn green-btn ease']")
private WebElement addateam;

@FindBy(xpath="//input[@id='TeamName']")
private WebElement teamname;

@FindBy(xpath="//span[@class='k-icon k-i-arrow-s']")
private WebElement worktype;

@FindBy(xpath="//li[contains(text(),'Kiosk')]")
private WebElement wtkiosk;


@FindBy(xpath="//input[@class='btn green-btn ease done']")
private WebElement create;

@FindBy(xpath="//a[contains(text(),'Continue To Add Stakeholders')]")
private WebElement createstake;
@FindBy(xpath="//a[contains(text(),'Review & Finish')]")
private WebElement review;

public void review() {
	wc.clickOnElement(review);
}

public void create() {
	
	wc.clickOnElement(create);
	
}


public void createstake() {
	
	wc.clickOnElement(createstake);
	
}


public void wtkiosk() {
	wc.clickOnElement(wtkiosk);
}

//Select wt= new Select((WebElement) driver.findElements(By.xpath("")));


public void worktype() {
	wc.clickOnElement(worktype);
}
public void teamname(String teamnames) {
	
	wc.typeText(teamname, teamnames);
}

public void addateam() {
	wc.clickOnElement(addateam);
}

/*public void muladdteam() {
wc.clickOnElement(teamadd);

}*/
public void multeams() {
wc.clickOnElement(multeam);

}
public void teamname() {
	teamname.sendKeys();
	
	
}
public void team() {
	wc.clickOnElement(team);
	}
public void email(String email2) {
	wc.typeText(email,email2);
//email.sendKeys(email2);
}

public void password( String password2) {
	//password.sendKeys(password2);
	wc.typeText(password,password2);
}
public void login() {
	wc.clickOnElement(login);
}



}
