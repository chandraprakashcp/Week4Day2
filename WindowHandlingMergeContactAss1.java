package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingMergeContactAss1 {
	
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Contacts")).click();
	
	//Click on Merge Contacts using Xpath Locator
	driver.findElement(By.xpath("//a[@href=\"/crmsfa/control/mergeContactsForm\"]")).click();
	//7. Click on Widget of From Contact
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
	
	 Set <String> allwindowhaldeler=driver.getWindowHandles();
	 List<String>allwindows= new ArrayList<>(allwindowhaldeler);
	 WebDriver window = driver.switchTo().window(allwindows.get(1));
	 System.out.println(window.getTitle());
	 Thread.sleep(3000);
	 //8. Click on First Resulting Contact
	 driver.findElement(By.xpath("//span[text()='Phone']")).click();
	 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]")).click();
	driver.switchTo().window(allwindows.get(0));
	System.out.println(window.getTitle());
	Thread.sleep(3000);
	 //9. Click on Widget of To Contact
	 driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	 
	 Set <String> allwindowhaldeler1=driver.getWindowHandles();
	 List<String>allwindows1= new ArrayList<String>(allwindowhaldeler1);
	 WebDriver window1 = driver.switchTo().window(allwindows1.get(1));
	 System.out.println(window1.getTitle());
	 Thread.sleep(3000);
	 //10. Click on Second Resulting Contact
	 
	 driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		
		driver.switchTo().window(allwindows1.get(0));
		 System.out.println(window1.getTitle());
		Thread.sleep(3000);
	 // 11. Click on Merge button using Xpath Locator
	 driver.findElement(By.xpath("//a[text()='Merge']")).click();
	 Thread.sleep(3000);
	 //12. Accept the Alert
	 driver.switchTo().alert().accept();
	String title= driver.getTitle();
	System.out.println(title);
	 
	/*
	 * //Pseudo Code
	 * 
	 
	 * 	
	 * 6. 
	 * 
	 * 7. Click on Widget of From Contact
	 * 
	 * 8. Click on First Resulting Contact
	 * 
	 * 9. Click on Widget of To Contact
	 * 
	 * 10. Click on Second Resulting Contact
	 * 
	 * 11. Click on Merge button using Xpath Locator
	 * 
	 * 12. Accept the Alert
	 * 
	 * 13. Verify the title of the page
	 */
	
}
}
