package com.herokuapp.theinternet;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PositiveTests {
	@Test
	public void loginTest() {
		
		// create driver		
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//sleep for 3 second
		sleep(1000);
		
		//URL setting
		String baseUrl = "https://www.google.com";
		// Maximizing the window
		driver.manage().window().maximize();
		// Fetching the URL
		driver.get(baseUrl);
		// Sleep
		sleep(2000);
		
		try {
			boolean ggleSearchBtnDisplay = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']")).isDisplayed();
			if(ggleSearchBtnDisplay) {
				System.out.println("Button Is Displayed");
			}else {
				driver.close(); 
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Button Not Found");
			//e.printStackTrace();
		}
		
		driver.close();
		/*
		 * WebElement username = driver.findElement(By.id("login_username"));
		 * username.sendKeys("bsaurabh");
		 * 
		 * WebElement password = driver.findElement(By.id("secretkey"));
		 * password.sendKeys("hrxtrfktcv");
		 * 
		 * driver.findElement(By.id("secretkey")).submit(); sleep(2000);
		 */
		// Driver close
		driver.close();
		
		// sleep function
	}	
		private void sleep(long m) {
			try {
				Thread.sleep(m);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
