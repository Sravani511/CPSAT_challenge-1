package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment3 {
	/*
	 * Write a method to find the count (number of) links on the homepage of Flipkart. 
	 * Write another method to print link text and URLs of all the links
	 * on the page of Flipkart.
	 */
@Test
	public void filpkart()
	{
	ChromeDriver chrome = new ChromeDriver();
	 System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		chrome.get("http://www.flipkart.com");
		chrome.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		chrome.close();
		
		
	}

}
