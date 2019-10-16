package selenium;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task2 {
	ChromeDriver chrome = new ChromeDriver();
	@Test
	public void onlineRegistration() {
		System.setProperty("webdriver.gecko.driver", "home/sravani/Downloads/geckodriver");
		///home/sravani/Downloads/geckodriver
		chrome.get("https://www.cii.in/OnlineRegistration.aspx");
		chrome.manage().window().maximize();
		Select attendees = new Select(chrome.findElement(By.id("drpAttendee")));
		attendees.selectByVisibleText("3");
		
		Select title1 = new Select(chrome.findElement(By.xpath("//*[@name='Gridview1$ctl02$drpTitle']")));
		title1.selectByVisibleText("Admiral");
		
		Select title2 = new Select(chrome.findElement(By.id("Gridview1_ctl03_drpTitle")));
		title2.selectByVisibleText("CA");
		
		Select title3 = new Select(chrome.findElement(By.id("Gridview1_ctl04_drpTitle")));
		title3.selectByVisibleText("CS");
		
		//List<String> options = new ArrayList<String>();
		
		Select dropDown = new Select(chrome.findElement(By.id("Gridview1_ctl04_drpTitle")));
		List<WebElement> options = dropDown.getOptions();
		int itemCount = options.size();
		for(int i=0;i<itemCount;i++)
		{
		System.out.println(options.get(i).getText());
		}
		chrome.close();
		
		
		
	}

}
