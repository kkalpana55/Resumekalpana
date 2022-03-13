package pages;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import library.basepage;
import library.webactionutils;

public class exportteampage extends basepage {
	
	public exportteampage(WebDriver driver,webactionutils wc){
		super(driver,wc);
				}
	
	@FindBy(id="Email")
	private WebElement email;
	@FindBy(id="Password")
	private WebElement password;
	@FindBy(xpath="//input[@class='btn login-btn']")
	private WebElement login;
	@FindBy(xpath="//*[@id='exportDropDown']/button/span")
		private WebElement export;
	@FindBy(xpath="//*[@id=\"exportDropDown-content\"]/button/span")
	private WebElement excelexport;
	
	//member functions
		public void email(String ename) {
			wc.typeText(email,ename);
		//email.sendKeys("kkalpana55@gmail.com");
		}
		
	public void password(String pname) {
			//password.sendKeys("temp1234");
			wc.typeText(password,pname);
		}
	public void login() {
		wc.clickOnElement(login);
		//login.click();
	}
	
	public void exports() {
		
		export.click();
		
	}
	
	
public  boolean excelexports() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException  {
		Thread.sleep(2000);
		excelexport.click();
		Thread.sleep(2000);
		
		String filePath = System.getProperty("user.home")+"\\Downloads\\TeamList.xlsx";
		File folder = new File(System.getProperty("user.home")+"\\Downloads");
		 
		//List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		
		File f = null;
		     //Look for the file in the files
		     // You should write smart REGEX according to the filename
		     for (File listOfFile : listOfFiles) {
		         if (listOfFile.isFile()) {
		              String fileName = listOfFile.getName();
		               System.out.println(fileName);
		               
		               if (fileName.matches("TeamList ().xlsx")) {
		            	  
		                   f = new File(fileName);
		                  
		                }
		            }
		        }
		Assert.assertTrue(found, "Downloaded document is found");
		f.deleteOnExit();
		System.out.println(filePath);
		Thread.sleep(2000);
	
    
		
		
		/*FileInputStream file=null;
		try {
			
		file= new FileInputStream(filePath);
		
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		
		Workbook book = null;
		try {
			book=org.apache.poi.ss.usermodel.WorkbookFactory.create(file);
			
			
		}
		catch(IllegalFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();	
		}
		
		
		String sheetname = null;
		Object sheet = book.getSheet(sheetname);
		Object[][] data= new Object[((HSSFSheet) sheet).getLastRowNum()][((HSSFSheet) sheet).getRow(0).getLastCellNum()];
		for(int i=0;i<((HSSFSheet) sheet).getLastRowNum();i++) {
			
			for(int k=0;k<((HSSFSheet) sheet).getRow(0).getLastCellNum();k++) {
				data[i][k]=((HSSFSheet) sheet).getRow(i+1).getCell(k).toString();
			}
			
		}
		return data;
		}*/
	/* wb =new HSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		
		
			Row row11 =sheet.getRow(0);
			Cell cell1 = (Cell) row11.getCell(0);
			System.out.println(cell);
			
			
				System.out.println( sheet.getRow(0).getCell(0));
				
			}*/
			
		
		try {
		
			File f1 = new File(filePath);
			
			
		FileReader fr = new FileReader(f1);
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
		return false;
}}
		
		
		
		
			
			
			/*ArrayList<String> data = new ArrayList<String>();
			
			
			Workbook wb= (Workbook) WorkbookFactory.create(fin);
			Sheet sht=(Sheet) wb.getSheet(sheetname);
			int rowCount = ((org.apache.poi.ss.usermodel.Sheet) sht).getLastRowNum()-((org.apache.poi.ss.usermodel.Sheet) sht).getFirstRowNum();
			for (int i = 0; i < rowCount+1; i++)
			{
			Row row = ((org.apache.poi.ss.usermodel.Sheet) sht).getRow(i);
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++)
			
			{
			//Store Excel data in ArrayList
			data.add(row.getCell(j).getStringCellValue());
			}
			System.out.println();
			}

			}
			catch (Exception e)
			{
			e.printStackTrace();
			}
			Object data = null;
			return data;*/
			


			
		
			
		
	

	


