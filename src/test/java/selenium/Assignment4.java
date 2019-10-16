package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment4 {
	/*
	 * Browse to Ebay website. Write a method which do following: On the homepage,
	 * there is a search box, type some product (say Apple Watches). From categories
	 * dropdown, select the category of your product (say Watches). Click Search
	 * button. Write a method to print the result of the product. Write a method to
	 * print Nth product say 10th Product. Write a method to print all products from
	 * 1st page. Write a method to print all products along with scroll down.
	 */
@Test
public void ebay() throws InterruptedException {
	 String text ;
	ChromeDriver chrome = new ChromeDriver();
	 JavascriptExecutor js = (JavascriptExecutor) chrome;
	 
	 System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		chrome.get("http://www.ebay.in");
	 chrome.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Apple Watches");
	 chrome.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")).click();
	 Thread.sleep(2000);
	 
	chrome.findElement(By.xpath("//*[@class='s-item__title s-item__title--has-tags']"));
	//Write a method to print the result of the product
	 for(int i=0;i<=12;i++)
	 {
		 text = chrome.findElementsByXPath("//*[@class='s-item__title s-item__title--has-tags']").get(i).getText();
		 System.out.println(text);
			 
	 }
	 
	 js.executeScript("window.scrollBy(0,30000)");
	chrome.findElement(By.xpath("//div[@class='srp-ipp__control--legacy']")).click();
	 
	 //chrome.close();
	 
	
	 //System.out.println(text);
	 ////*[@class="s-item__title s-item__title--has-tags"]
	
}
}
