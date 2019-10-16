package selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment9 {
	@Test
	public void gmail() throws InterruptedException {
		ChromeDriver chrome = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		
		chrome.get("https://mail.google.com");
		Thread.sleep(2000);
		chrome.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]")).sendKeys("sravani.b@qapitol.com");
		chrome.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		Thread.sleep(2000);
		chrome.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]")).sendKeys("sravanimurthy");
		chrome.findElement(By.xpath(("(//span[@class='RveJvd snByac'])[1]"))).click();
		List<WebElement> list= chrome.findElements(By.xpath("//*[@class='aim']"));
		System.out.println("Total count of mails" +list.size());
		chrome.close();
		
		//*[@class="zA yO"]
	}

}
