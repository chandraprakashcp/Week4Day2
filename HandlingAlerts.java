package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("chandraprakash");
		
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		
		
		
		if (text.contains("chandraprakash")) {
			System.out.println("The Text Contains" +text);	
		}
		
		driver.switchTo().alert().accept();
		
		
		

		
		
		//1) Load the URL
		//2) Click on Try It Button (Hint: It is inside a frame)
		//3) Switch to the alert
		//4) Type your name on the alert
		//5) Click Ok on the alert
		//6) Get the text appearing on the browser
		//7) Check if your name exist there !!
	}

}
