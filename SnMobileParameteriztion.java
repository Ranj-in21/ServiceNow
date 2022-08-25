package serviceNowTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class SnMobileParameteriztion extends ProjectSpecificationMethod{
	
		@Test
	
	public void ServiceNowMobile() {
	
		Shadow dom = new Shadow(driver);	
		dom.setImplicitWait(30);
		WebElement search = dom.findElementByXPath("//input[@id='filter']");
		search.sendKeys("Service Catalog", Keys.ENTER);
	
		WebElement all1 = dom.findElementByXPath("//div[@id='all']"); all1.click();
		dom.setImplicitWait(10);  
		WebElement enter = dom.findElementByXPath("//input[@id='filter']");
		enter.sendKeys(Keys.ENTER);
	
		WebElement frame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
	
		driver.findElement(By.xpath("//a/strong[text()='iPhone 6s']")).click();
	
		WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
		Select colordrop = new Select(color);
		colordrop.selectByValue("gold");
	
		WebElement gigs = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select gigsdrop = new Select(gigs);
		gigsdrop.selectByValue("onehudred_twentyeight");
	
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
	
		System.out.println(driver.getTitle());
	
	}

	

}
