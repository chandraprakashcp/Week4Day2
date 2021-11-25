package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import week2.day2.Dropdown;

public class FramesAssignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		String title= driver.getTitle();
		System.out.println(title);
		
		WebElement findElement = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(findElement);
		
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Topic Name is about Cat");
		
		WebElement findElement2 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(findElement2);
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following::input")).click();
		
		//switch out of the frame
		driver.switchTo().defaultContent();
		
		//moving to new frame
		WebElement findElement3 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(findElement3);
		driver.findElement(By.id("animals")).click();
		
		
		//dropdowns
		
		WebElement findElement4 = driver.findElement(By.id("animals"));
		Select findElement5= new Select(findElement4);
		findElement5.selectByValue("babycat");
		
		driver.switchTo().defaultContent();
		driver.close();
		
	}

}
