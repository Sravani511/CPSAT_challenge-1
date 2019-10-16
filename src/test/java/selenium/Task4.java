package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Task4 {
	ChromeDriver chrome = new ChromeDriver();
	@Test
	public void optionSelection() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		chrome.get("https://www.hometown.in/");
		Thread.sleep(2000);
		chrome.manage().window().maximize();
      //  chrome.findElement(By.className("styles_closeIcon__1QwbI")).click();
        chrome.findElement(By.xpath("//a[contains(text(),'Electronics')]")).click();
        Thread.sleep(2000);
      chrome.findElement(By.xpath("//div[@class='Div-ln5jk2-0 TtvCJ']/div[5]")).click();
      chrome.findElement(By.xpath("//*[text()='Black']")).click();
      Thread.sleep(2000);
      Actions action = new Actions(chrome);
      WebElement firstElement = chrome.findElement(By.xpath("(//img[@class='Product__ProductImg-sc-1rop1s7-0 fABMoW'])[1]"));
      action.moveToElement(firstElement).perform();
      chrome.findElement(By.xpath("//*[@class='QuickView__QuickViewBtn-sc-1sntg1-0 isPHJW'][1]")).click();
     String searchContent =  chrome.findElement(By.xpath("//*[@class='Heading-sc-1xt1x3f-0 efiseG']")).getText();
     System.out.println(searchContent);
   
     Assert.assertTrue(searchContent.contains("Black"));
     chrome.findElement(By.xpath("//*[@class='styles_closeButton__20ID4']")).click();
     String verifiedText = chrome.findElement(By.xpath("//*[@class='_1C7t6hCkKmMddDs8HIk_KY']")).getText();
     System.out.println(verifiedText);
     Assert.assertTrue(verifiedText.contains("Black"));
     chrome.close();
	}

}
