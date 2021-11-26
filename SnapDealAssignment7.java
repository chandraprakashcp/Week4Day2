package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment7 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		//2. Go to Mens Fashion
		
		Thread.sleep(5000);
		
		WebElement mousemove = driver.findElement(By.xpath("//div[@id='leftNavMenuRevamp']/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]"));
		Actions move= new Actions(driver);
		move.moveToElement(mousemove).perform();
		
		
		//3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		WebElement countsp = driver.findElement(By.xpath("//div[@class='child-cat-name selected']/following-sibling::div[1]"));
		
		System.out.println(countsp.getText());
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//6. Sort by Low to High
		driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::i")).click();
		
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
	
		
		//7. Check if the items displayed are sorted correctly
		
		String getpriceOne = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]")).getText();
		String partstring=getpriceOne.substring(6);
		System.out.println(partstring);
		int Price1=Integer.parseInt(partstring);
		
		String getpriceOne2 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[20]")).getText();
		String partstring2=getpriceOne2.substring(6);
		System.out.println(partstring2);
		int Price2=Integer.parseInt(partstring2);
		
		if (Price1==Price2) {
			
			System.out.println("Not sorted properly"+Price1+ " " +Price2);
		} else {
			System.out.println("Sorted properly"+Price1+ " " +Price2);
		}
		
		//8.Select the price range (900-1200)
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		
		//9.Filter with color Navy
		driver.findElement(By.xpath("//input[@value='Navy']/following-sibling::label[1]")).click();
		
		//10 verify the all applied filters
		
		//11. Mouse Hover on first resulting Training shoes
		WebElement mouseoveraa = driver.findElement(By.xpath("(//source[@class='product-image']/following-sibling::img)[1]"));
		Actions mousemov=new Actions(driver);
		mousemov.moveToElement(mouseoveraa).perform();
		//12. click QuickView button
		driver.findElement(By.xpath("(//div[contains(@class,'center quick-view-bar')])[1]")).click();
		
		//13. Print the cost and the discount percentage
		String textprice = driver.findElement(By.xpath("//div[contains(@class,'product-price pdp-e-i-PAY-l')]//span[1]")).getText();
		System.out.println(textprice);
		
		String textdisc = driver.findElement(By.xpath("//span[@class='payBlkBig']/following-sibling::span[1]")).getText();
		System.out.println(textdisc);
		
		//14. Take the snapshot of the shoes
		WebElement screenshot = driver.findElement(By.xpath("//img[@itemprop='image']"));
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("chandra/shoe.png");
		FileUtils.copyDirectory(source, dest);
		
		//15. Close the current window
		driver.close();
		//16. Close the main window
		driver.quit();
		/*1. Launch https://www.snapdeal.com/  
			2. Go to Mens Fashion
			3. Go to Sports Shoes
			4. Get the count of the sports shoes
			5. Click Training shoes
			6. Sort by Low to High
			7. Check if the items displayed are sorted correctly
			8.Select the price range (900-1200)
			9.Filter with color Navy 
			10 verify the all applied filters 
			11. Mouse Hover on first resulting Training shoes
			12. click QuickView button
			13. Print the cost and the discount percentage
			14. Take the snapshot of the shoes.
			15. Close the current window
			16. Close the main window */
		
		
		
		
		
		
	}

}
