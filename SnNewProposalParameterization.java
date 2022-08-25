package serviceNowTestNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class SnNewProposalParameterization extends ProjectSpecificationMethod {
	
		@Test
	public void newProposal() {
		
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		WebElement search = dom.findElementByXPath("//input[@id='filter']");
		search.sendKeys("Proposal", Keys.ENTER);
		
		WebElement all1 = dom.findElementByXPath("//div[@id='all']"); all1.click();
		dom.setImplicitWait(20);  
		WebElement enter = dom.findElementByXPath("//input[@id='filter']");
		enter.sendKeys(Keys.ENTER);
		
		WebElement frame = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.std_change_proposal.category']")).click();
		
		Set<String> win = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(win);
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(windows.get(0));
		
		
		WebElement frame1 = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame1);
		
		
//		dom.setImplicitWait(10);
		driver.findElement(By.xpath("//div//a[@id='lookup.std_change_proposal.short_description']")).click();
		
		Set<String> win1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(win1);
		driver.switchTo().window(windows1.get(1));
		
		driver.findElement(By.xpath("//a[text()='Issue with networking']")).click();
		driver.switchTo().window(windows1.get(0));
		
		
		WebElement frame2 = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(frame2); 
		  
		driver.findElement(By.xpath("(//span[@class='tab_caption_text'])[2]")).click(); 
		dom.setImplicitWait(10);
		  
		driver.findElement(By.xpath("//a/span[@id='select2-chosen-6']")).click();
		
		
		driver.findElement(By.xpath("//div[text()='Service offering']")).click(); 
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		  
		driver.findElement(By.xpath("(//a[@class='column_head list_hdrcell table-col-header'])[1]")).click();
		String text = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		System.out.println(text);		
			
		String state = driver.findElement(By.xpath("(//td[@class='vt'])[4]")).getText();	
			System.out.println("State: " +state);
			
		
		
		
	}

}
