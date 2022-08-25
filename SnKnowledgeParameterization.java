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

public class SnKnowledgeParameterization extends ProjectSpecificationMethod {
	
		@BeforeTest
	public void setup() {
		
		excelFile = "KnowledgeExcel";
			
	}	
	
		@Test(dataProvider = "TestData")
	public void knowledge(String Description) {
		
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement search = dom.findElementByXPath("//input[@id='filter']");
		search.sendKeys("Knowledge", Keys.ENTER);
	
		WebElement all1 = dom.findElementByXPath("//div[@id='all']"); all1.click();
		dom.setImplicitWait(10);  
		WebElement enter = dom.findElementByXPath("//input[@id='filter']");
		enter.sendKeys(Keys.ENTER);
	
		WebElement frame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
	
		dom.setImplicitWait(20);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']")).click();
	
		Set<String> win = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(win);
		driver.switchTo().window(windows.get(1));
	
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(windows.get(0));
	
		WebElement frame1 = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
	
		driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']")).click();
		driver.findElement(By.xpath("(//div/span[@class='label'])[4]")).click();
	
		driver.findElement(By.xpath("//div/span[text()='Java']")).click();
	
		driver.findElement(By.xpath("//button[@class='btn btn-primary category-ok-btn']")).click();
	
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys(Description);
	
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	
	}

	
}
