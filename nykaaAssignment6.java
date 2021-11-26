package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nykaaAssignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"headerMenu\"]/div[1]/ul[2]/li/a"));
		Actions movebrand= new Actions(driver);
		movebrand.moveToElement(findElement).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"brandCont_Popular\"]/ul/li[5]/a/img")).click();
		System.out.println(driver.getTitle()); 
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//*[@id=\"filter-sort\"]/div/div/ul/div[4]/label/div[2]")).click();
		//6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//div[@id='first-filter']//span")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
		//7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//*[@id=\"custom-scroll\"]/div/div[14]/label/div[2]")).click();
		Thread.sleep(5000);
		//8)check whether the Filter is applied with Shampoo
		WebElement filtercheck = driver.findElement(By.xpath("//*[@id=\"filters-listing\"]/div[1]/div[2]"));
		String text = filtercheck.getText();
		System.out.println(text);
		
		if (text.contains("Shampoo")) {
			System.out.println("Filter is applied with Shampoo");
			
		} else {
			System.out.println("Filter is NOT applied with Shampoo");
		}
		
		//9) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		Thread.sleep(5000);
	//10) GO to the new window and select size as 175ml
		Set<String> allwindowhandels= driver.getWindowHandles();
		List<String> allhandel= new ArrayList<>(allwindowhandels);
		driver.switchTo().window(allhandel.get(1));
		Thread.sleep(5000);
		WebElement elementdropdown = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dropdown=new Select(elementdropdown);
		dropdown.selectByVisibleText("175ml");
		
		//11) Print the MRP of the product
		String elementtext = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/div[2]/span[2]")).getText();
		System.out.println(elementtext);
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		Thread.sleep(5000);
		//13) Go to Shopping Bag
		driver.findElement(By.xpath("//*[@id=\"header_id\"]/div[2]/div/div[2]/div[2]/button")).click();
		Thread.sleep(5000);
		//14) Print the Grand Total amount
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(iframe);
		String stringGrandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println(stringGrandTotal);
		
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
		driver.switchTo().defaultContent();
		//16) Click on Continue as Guest
		
		driver.findElement(By.xpath("//buttob[text()='CONTINUE AS GUEST']")).click();
		Thread.sleep(5000);
		
		String text2GrandAmnt = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		
		if (text2GrandAmnt.equals(stringGrandTotal)) {
			System.out.println("Both Grand Totals are same"+stringGrandTotal);
		} else {
			System.out.println("Both Grand Totals are same"+stringGrandTotal+" and "+text2GrandAmnt);
		}
		/* 1) Go to https://www.nykaa.com/
			//2) Mouseover on Brands and Search L'Oreal Paris
			//3) Click L'Oreal Paris
			//4) Check the title contains L'Oreal Paris(Hint-GetTitle)
			//5) Click sort By and select customer top rated
			//6) Click Category and click Hair->Click haircare->Shampoo
			//7) Click->Concern->Color Protection
			//8)check whether the Filter is applied with Shampoo
			9) Click on L'Oreal Paris Colour Protect Shampoo
			10) GO to the new window and select size as 175ml
			11) Print the MRP of the product
			12) Click on ADD to BAG
			13) Go to Shopping Bag 
			14) Print the Grand Total amount
			15) Click Proceed
			16) Click on Continue as Guest
			17) Check if this grand total is the same in step 14
			 18) Close all windows
			 */

	}
}



