package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	ChromeDriver chrome = new ChromeDriver();
	@BeforeTest
	public void lanchingApp() {
		System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
		
		chrome.get("https://opensource-demo.orangehrmlive.com");
		String title = chrome.getTitle();
		Assert.assertEquals(title,"OrangeHRM");
	}
	
	
	  @Test (priority=0)
	  public void login() {
	  chrome.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin"
	  + Keys.ENTER);
	  chrome.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(
	  "admin123"); chrome.findElement(By.xpath("//input[@type='submit']")).click();
	  chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  chrome.findElement(By.id("menu_dashboard_index")).click();
	  chrome.findElement(By.xpath("(//span[@class='quickLinkText'])[1]")).click();
	  chrome.findElement(By.id("assignleave_txtEmployee_empName")).
	  sendKeys("Linda Anderson1"); Select leaveType = new
	  Select(chrome.findElement(By.name("assignleave[txtLeaveType]")));
	  leaveType.selectByVisibleText("Vacation US");
	  chrome.findElement(By.id("leaveBalance_details_link")).click();
	  chrome.findElement(By.
	  xpath("//div[@class='modal hide in']//div//input[@id='closeButton']")).click(
	  );
	  chrome.findElement(By.xpath("//input[@id='assignleave_txtFromDate']")).click(
	  ); Select date = new
	  Select(chrome.findElement(By.xpath("//select[@class='ui-datepicker-month']"))
	  ); date.selectByVisibleText("Oct");
	  chrome.findElement(By.xpath("//a[text()='4']")).click(); Select duration =
	  new Select(chrome.findElement(By.xpath(
	  "//select[@id='assignleave_duration_duration']")));
	  duration.selectByVisibleText("Half Day"); Select day = new
	  Select(chrome.findElement(By.id("assignleave_duration_ampm")));
	  day.selectByVisibleText("Afternoon");
	  chrome.findElement(By.xpath("//input[@id='assignBtn']")).click(); }
	 
        @Test(priority=1)
        public void admin() {
        	chrome.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
        	chrome.findElementByName("btnAdd").click();
        	chrome.findElement(By.xpath("//select[@class='formSelect valid']"));
        	
        	
        }
        
	
	
	
	/*
	 * @Test public void dashboard() throws InterruptedException {
	 * chrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 * chrome.findElement(By.id("menu__Performance")).click();
	 * 
	 * 
	 * }
	 */

}
