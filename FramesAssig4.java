package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.utils.FileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssig4 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		
		Thread.sleep(5000);
		
		WebElement framename = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[1]"));
		driver.switchTo().frame(framename);
		
		//1.Take the the screenshot of the click me button of first frame
		
		WebElement print = driver.findElement(By.id("Click"));
		File sourceSS = print.getScreenshotAs(OutputType.FILE);
		File desc= new File("ClickButtonSS.png");
		FileUtils.copyFile(sourceSS, desc);
		driver.switchTo().defaultContent();
		
		 List<WebElement> webElement = driver.findElements(By.xpath("//div[@id='wrapframe']"));
		
		System.out.println(webElement.size());
		
		
		//2.Find the number of frames
		  //- find the Elements by tagname - iframe
		  //- Store it in a list
		  //- Get the size of the list. (This gives the count of the frames visible to the main page)
	}

}
