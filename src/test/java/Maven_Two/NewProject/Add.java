package Maven_Two.NewProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Add {
 static WebDriver driver;
	@Test(groups="a")
public void project() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\prem\\eclipse-workspace\\NewProject\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.close();
}
	@Test(groups="b")
	public void project1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prem\\eclipse-workspace\\NewProject\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.close();
}

	@Test(groups="a")
	public void project3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\prem\\eclipse-workspace\\NewProject\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("password");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button")).click();
		driver.close();
		
		
		
	}	
	
	
}