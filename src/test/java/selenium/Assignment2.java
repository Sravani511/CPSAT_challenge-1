package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment2 {
	/*
	 * Navigate to “http://www.fb.com” Verify that page is redirected to
	 * “http://www.facebook.com”, by getting the current URL. (use if-else condition
	 * to verify this condition or use Assert.assertequals()
	 * Verify that there is a “Create an account”section on the page. 
	 * Fill in the text boxes: First Name, Surname, Mobile
	 * Number or email address, “Re-enter mobile number”, new password. Update the
	 * date of birth in the drop-down. Select the gender. Click on “Create an
	 * account”.
	 */
	@Test
	
	public void facebookLogin() throws InterruptedException {
		ChromeDriver chrome = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver", "/home/sravani/Downloads/ChromeDriver76/chromedriver");
			
		    String url = "http://www.fb.com";
		    
			chrome.get(url);
			Assert.assertEquals(url, "http://www.fb.com");
			
			String text = chrome.findElement(By.xpath("//span[text()='Create an account']")).getText();
			System.out.println(text);
			chrome.findElementByName("firstname").sendKeys("John");
			chrome.findElementByName("lastname").sendKeys("James");
			chrome.findElementByName("reg_email__").sendKeys("9988787879");
			chrome.findElementByName("reg_passwd__").sendKeys("John@123");
			Select birthday= new Select(chrome.findElementByName("birthday_day"));
			birthday.selectByVisibleText("20");
			Select month = new Select(chrome.findElementByName("birthday_month"));
			month.selectByVisibleText("Nov");
			Select year = new Select(chrome.findElementByName("birthday_year"));
			year.selectByVisibleText("1996");
			chrome.findElement(By.xpath("(//input[@class='_8esa'])[2]")).click();
			Thread.sleep(2000);
			chrome.findElement(By.xpath("(//*[text()='Sign Up'])[1]")).click();
			String retrivedText = chrome.findElementById("reg_error_inner").getText();
			System.out.println(retrivedText);
								
	}

}
//name="firstname"