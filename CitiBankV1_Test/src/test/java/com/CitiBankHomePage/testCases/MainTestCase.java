package com.CitiBankHomePage.testCases;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainTestCase {
	
	public static void main ( String args[]) throws InterruptedException
	{
				System.setProperty("webdriver.chrome.driver", "/home/mihup-soumit/Documents/eclipse-workspace/CitiBankV1_Test/Drivers/Chromedriver/chromedriver_linux64/chromedriver");
				WebDriver driver =new ChromeDriver();
				driver.manage().window().maximize();
			
			
				JavascriptExecutor js = (JavascriptExecutor) driver;
				driver.get("https://www.online.citibank.co.in/");
				
				 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 
				 WebElement Text_BAtm = driver.findElement(By.xpath("//img[@alt='Branch/ATM']"));
				 Text_BAtm.click();
				
				 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				 
				 js.executeScript("window.scrollBy(0,200)");
				 
				 Thread.sleep(4000);
				 
				 //*Block of code to select the value Kolkata from drop-down of CitiBank Branch
				 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/ul[2]/div[2]/div/div[1]/div/div[2]/form/div/a[2]")).click();
				 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/ul[2]/div[2]/div/div[1]/div/div[2]/form/div/ul/li[14]")));
				 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/ul[2]/div[2]/div/div[1]/div/div[2]/form/div/ul/li[14]")).click();
				 
				 Thread.sleep(8000);
				 
				System.out.println(driver.findElement((By.xpath ( "//div[@class='cp_ques_contanner rounded']//a[text()= 'Phone Number']"))).getText());
					 
				driver.close();
	}
}
	
	