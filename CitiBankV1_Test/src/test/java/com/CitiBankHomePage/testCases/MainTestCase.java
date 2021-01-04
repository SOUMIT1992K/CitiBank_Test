package com.CitiBankHomePage.testCases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestCase {
	
	private static BufferedReader br;

	public static void main ( String args[]) throws InterruptedException, IOException
	{
				System.setProperty("webdriver.chrome.driver", "/home/mihup-soumit/git/CitiBank_Test/CitiBankV1_Test/Drivers/Chromedriver/chromedriver_linux64/chromedriver");
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
				 
				Thread.sleep(5000);
				 
				//*Block of code to select the value Kolkata from drop-down of CitiBank Branch
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/ul[2]/div[2]/div/div[1]/div/div[2]/form/div/a[2]")).click();
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/ul[2]/div[2]/div/div[1]/div/div[2]/form/div/ul/li[14]")));
				driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/ul[2]/div[2]/div/div[1]/div/div[2]/form/div/ul/li[14]")).click();
				 
				Thread.sleep(5000);
				
					driver.findElement(By.id("city18"));

			        String text = "Phone Number";
			        String bodyText = driver.findElement(By.id("city18")).getText();
			        String path = "/home/mihup-soumit/Desktop/w.txt";
			        Files.write( Paths.get(path), bodyText.getBytes());

			        Assert.assertTrue("Text not found!", bodyText.contains(text));

			        try (PrintWriter pw = new PrintWriter("/home/mihup-soumit/Desktop/write_the_phone_numbers.txt")) {
						// Regular expression for mobile number
						Pattern p = Pattern.compile("(0/033)?[0-9]{8}");

						br = new BufferedReader(new FileReader("/home/mihup-soumit/Desktop/w.txt"));
						String line = br.readLine();

						while (line != null)
						{
						    Matcher m = p.matcher(line);

						    while (m.find())
						    {
						        // Write the mobile number to output.txt file
						        pw.println("033" +m.group());
						    }

						    line = br.readLine();
						}
						pw.flush();
					}

			        driver.close();
	}
}
	
	