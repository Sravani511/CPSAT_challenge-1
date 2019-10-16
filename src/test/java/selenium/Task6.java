package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task6 {
	public ChromeDriver chrome; 

	@BeforeTest
	public void launchURL() {
		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		chrome = new ChromeDriver();
		chrome.get("https://www.woodlandworldwide.com");
		chrome.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void products() throws FileNotFoundException, IOException {
		
		File file = new File("./Task6.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(file));
	    XSSFSheet sheet = book.getSheet("Sheet1"); 
		XSSFRow row = sheet.getRow(0); 
		String firstItem = row.getCell(0).getStringCellValue();
		System.out.println(firstItem);
		chrome.findElement(By.xpath("//div[@class='floatright spirit-bg search-icon searchIcon']")).click();
		chrome.findElement(By.xpath("//input[@id='searchkey']")).sendKeys(firstItem);
		chrome.findElement(By.xpath("//input[@id='searchBtn']")).click();
		chrome.findElement(By.xpath("//label[@class='spirit-bg radio1'][1]")).click();
		List<WebElement> elements = chrome.findElements(By.xpath("//span[@class='mrp']"));
		 String[] str = new String[8];
	     String[] strtrim = new String[8];
	     int[] price = new int[8];
	     for(int i=0;i<8;i++) {
	            str[i]=elements.get(i).getText();
	            strtrim[i]=str[i].substring(2, str[i].length());
	            price[i]=Integer.parseInt(strtrim[i].toString());
	        }
	     for(int k=0; k <= 6; k++)
         {
             Assert.assertTrue(price[k] >= price[k+1]);
         }
	    
		 
	}
	
	  @Test (priority = 2)
	  public void Test2() throws FileNotFoundException, IOException, InterruptedException {
		  File file = new File("./Task6.xlsx"); 
		  XSSFWorkbook book1 = new XSSFWorkbook(new FileInputStream(file)); 
		  XSSFSheet sheet = book1.getSheet("Sheet1"); 
		  XSSFRow row = sheet.getRow(1);
		  String secondItem = row.getCell(0).getStringCellValue(); 
		  System.out.println(secondItem);
		  chrome.findElement(By. xpath("//div[@class='floatright spirit-bg search-icon searchIcon']")).click();
          chrome.findElement(By.xpath("//input[@id='searchkey']")).sendKeys(secondItem);
		  chrome.findElement(By.xpath("//input[@id='searchBtn']")).click();
		  Thread.sleep(2000);
		  chrome.findElement(By.xpath("//li[@class='spaceright radioSortBy']")).click();
		
		  List<WebElement> elements = chrome.findElements(By.xpath("//*[@class='offerPrices prize']"));
		  
		  String[] str = new String[8]; String[] strtrim = new String[8];
		  int[] price = new int[8]; 
		  for(int i=0;i<8;i++) 
		  { 
			  str[i]=elements.get(i).getText();
		  strtrim[i]=str[i].substring(2, str[i].length());
		  price[i]=Integer.parseInt(strtrim[i].toString()); 
		  }
		  for(int k=0; k <= 6; k++)
		  { 
			  Assert.assertTrue(price[k] >= price[k+1]); 
			  }
		 
		  
		  }
	  
	
	
	  @Test (priority = 3)
	  public void Test3() throws FileNotFoundException,
	  IOException { File file = new File("./Task6.xlsx"); 
	  XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(file)); 
	  XSSFSheet sheet = book.getSheet("Sheet1"); 
	  XSSFRow row = sheet.getRow(2);
	  String thirdItem = row.getCell(0).getStringCellValue(); 
	  System.out.println(thirdItem);
	 chrome.findElement(By.xpath("//div[@class='floatright spirit-bg search-icon searchIcon']")).click();
	  chrome.findElement(By.xpath("//input[@id='searchkey']")).sendKeys(thirdItem);
	  chrome.findElement(By.xpath("//input[@id='searchBtn']")).click();
	  chrome.findElement(By.xpath("//li[@class='spaceright radioSortBy']")).click();
	  List<WebElement> elements = chrome.findElements(By.xpath("//*[@class='offerPrices prize']"));
	  
	  String[] str = new String[8]; String[] strtrim = new String[8];
	  int[] price = new int[8]; 
	  for(int i=0;i<8;i++) 
	  { 
		  str[i]=elements.get(i).getText();
	  strtrim[i]=str[i].substring(2, str[i].length());
	  price[i]=Integer.parseInt(strtrim[i].toString()); 
	  }
	  for(int k=0; k <= 6; k++)
	  { 
		  Assert.assertTrue(price[k] >= price[k+1]); 
		  }
	  chrome.close();
	 
	  }
	  
}