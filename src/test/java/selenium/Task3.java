package selenium;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task3 {
	ChromeDriver chrome = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) chrome;

	@Test

	public void premierleague() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "home/sravani/Downloads/geckodriver");
		chrome.get("https://www.premierleague.com/");
		chrome.manage().window().maximize();
		// chrome.findElement(By.id("advertClose")).click();
		Thread.sleep(2000);
		chrome.findElement(By.xpath(("(//a[@href='/tables'])[2]"))).click();
		// chrome.findElement(By.id("advertClose")).click();
		js.executeScript("window.scrollBy(0,500)");
		// chrome.findElement(By.xpath("//div[@class='btn-primary
		// cookies-notice-accept']")).click();
		Actions action = new Actions(chrome);
		WebElement arsenal = chrome.findElement(By.xpath("//a[@href='/clubs/1/Arsenal/overview'][1]"));
		action.keyDown(Keys.SHIFT).click(arsenal).build().perform();
        // chrome.findElement(By.xpath("//a[contains(text(),'www.arsenal.com')]")).click();
		 Set<String> ids = chrome.getWindowHandles(); 
		 Iterator<String> it = ids.iterator(); 
		 String parentId = it.next(); String childId = it.next();
		  chrome.switchTo().window(childId);
		 System.out.println(chrome.findElement(By.xpath("//a[contains(text(),'www.arsenal.com')]")).getText());
         System.out.println(chrome.getTitle());
		  chrome.switchTo().window((parentId));
		  System.out.println(chrome.getTitle());
		  chrome.close();
		 
	}

}
