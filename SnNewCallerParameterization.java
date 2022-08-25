package serviceNowTestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class SnNewCallerParameterization extends ProjectSpecificationMethod{
	
		@BeforeTest
	public void setup() {
		
			excelFile = "CallerExcel";

	}	
	
	
		@Test(dataProvider = "TestData")
	public void newCaller(String firstName, String lastName, String Email, String Number, String phNumber, String Name) {
		
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement search = dom.findElementByXPath("//input[@id='filter']");
		search.sendKeys("Callers", Keys.ENTER);
		
		WebElement all1 = dom.findElementByXPath("//div[@id='all']"); all1.click();
		dom.setImplicitWait(10);  
		WebElement enter = dom.findElementByXPath("//input[@id='filter']");
		enter.sendKeys(Keys.ENTER);
		
		WebElement frame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
		
		dom.setImplicitWait(20);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(firstName, Keys.TAB);
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lastName, Keys.TAB);
		
		driver.findElement(By.xpath("//a[@id='lookup.sys_user.title']")).click();
		Set<String> win = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(win);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//a[text()='Junior Developer']")).click();
		
		driver.switchTo().window(windows.get(0));
		WebElement frame1 = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(Email, Keys.TAB);
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys(Number, Keys.TAB);
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys(phNumber);
		driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default']")).click();
		
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(Name, Keys.ENTER);
		String name = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
		
		if(name.equalsIgnoreCase(Name)) {
			
			System.out.println("New caller created record is found");
		}
		else {
			
			System.out.println("New caller record not found");
			
		}
		

	}

}
