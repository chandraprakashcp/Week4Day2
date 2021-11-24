package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomWindhandel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/s?k=Books&ref=nb_sb_noss_2");
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
		Set<String> windowHandle = driver.getWindowHandles();
		System.out.println(windowHandle.size());
		
		
		Set<String> windowHandle2 = driver.getWindowHandles();
		List <String> allhandelwindowlist = new ArrayList<String>(windowHandle2);

		
		driver.switchTo().window(allhandelwindowlist.get(1));
		System.out.println(driver.getTitle());
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("chandra/Snap1.png");
		FileUtils.copyFile(screenshotAs, destination);
		//driver.quit();
		//2) Click on the first book link
		//3) Print the number of window handles 
		//4) Switch the control to the second window
		//5) Print the title of the new window
		//6) Close all browsers

	}

}
