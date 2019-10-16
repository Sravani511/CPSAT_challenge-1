package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1 {

	ChromeDriver chrome = new ChromeDriver();
	@Test
	public void login() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		
		chrome.get("http://qatechhub.com");
		chrome.manage().window().maximize();
		//Closing the popup window
		chrome.findElement(By.xpath("(//*[@class='tcb-icon'])[7]")).click();
		//Write a method to print PASS if the title of the page matches with “QA Automation Tools Trainings and Tutorials | QA Tech Hub” else FAIL
		String title = chrome.getTitle();
	    System.out.println(title);	
	  
	    Assert.assertEquals(title,"QA Automation Tools Trainings and Tutorials | QA Tech Hub");
	    chrome.get("https://www.facebook.com");
	    Thread.sleep(2000);
	    //Navigate back to QA Tech Hub website
	    chrome.navigate().to("http://qatechhub.com");
	    //Print the URL of the current page
	    String url = chrome.getCurrentUrl();
	    System.out.println(url);
	    //Navigate forward
	    chrome.navigate().forward();
	    //Reload the page
	    chrome.navigate().refresh();
	    //
	    chrome.close();
		
	}
}