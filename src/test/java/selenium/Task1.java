package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {
	ChromeDriver chrome = new ChromeDriver();
	 JavascriptExecutor js = (JavascriptExecutor) chrome;

	@Test

	public void task1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		chrome.get("https://www.meripustak.com/");
		chrome.manage().window().maximize();
		WebElement image = chrome.findElementByXPath("//img[@title='Meripustak Online bookstore']");
		int ImageWidth = image.getSize().getWidth();
		System.out.println(ImageWidth);
		int ImageHeight = image.getSize().getHeight();
		System.out.println(ImageHeight);
		//WebElement ParentTwitterIcon = .findElement(By.xpath("./.."));
		
		WebElement twitter = chrome.findElement(By.xpath("//i[@class='fa fa-twitter sky_blue']"));
		String ParentTwitterIcon = twitter.findElement(By.xpath("./..")).getAttribute("href");
		System.out.println(ParentTwitterIcon);
		String ZeroItems = chrome.findElement(By.xpath("//span[@id='lblNoCartItem']")).getText();
		System.out.println(ZeroItems);
		
		//Assert.assertEquals(ZeroItems,"0 Item");
		if(chrome.findElement(By.id("lblNoCartItem")).getText().contains("0 Item"))
			
			    chrome.findElement(By.xpath("//a[@href='https://www.meripustak.com/cart'][1]")).click();
	
        String text = chrome.findElement(By.id("ContentPlaceHolder1_gvCartTable")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "No Item is Added In Cart yet.Cart is Empty!!!");
		chrome.findElement(By.xpath("//a[text()='Continue Shopping']")).click();
        chrome.findElement(By.xpath("//input[@name='search']")).sendKeys("Java Books" +Keys.ENTER);
        Thread.sleep(2000);
        chrome.findElement(By.xpath("//*[text()='Core Java: An Integrated Approach, New: Includes All Versions upto Java 8']")).click();
        chrome.findElement(By.id("ContentPlaceHolder1_AddtoCart")).click();
		if(chrome.getPageSource().contains("No Item is Added In Cart yet.Cart is Empty!!!")){
			System.out.println("Text is present");
		}
		else {
			System.out.println("No such text available");
		}
       chrome.close();
				
	}	 

}
