package serviceNowTestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ProjectSpecificationMethod {
	
	public RemoteWebDriver driver;
	
	public String excelFile;
	
		@Parameters({"browserName", "URL", "UserName", "PassWord"})
		@BeforeMethod
	public void preCondition(String browserName, String Url, String Username, String Password) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			} 
		else if(browserName.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			}
		
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.findElement(By.id("user_name")).sendKeys(Username);
		driver.findElement(By.id("user_password")).sendKeys(Password);
		driver.findElement(By.id("sysverb_login")).click();
		
		Shadow dom = new Shadow(driver); 
		dom.setImplicitWait(30);
		WebElement ele = dom.findElementByXPath("//div[@id='all']");
		ele.click();
		
		
	}
	
		@AfterMethod
	public void postCondition() {
			
			driver.close();

		}
	
		@DataProvider(name = "TestData")
		public String[][] fetchData() throws IOException {
		
			String[][] readData = SnExcelReadData.readData(excelFile);
			return readData;

		}
	
	
	
	
	
	
	

}
