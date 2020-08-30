package com.herokuapp.theinternet;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.googlesearch.learn.*;

public class GoogleTest {
	
	public static void main(String[] args) {
		googleTest();
	}
	@Test
	public static void googleTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		GoogleMain.textbox_search(driver).sendKeys("google");
		sleep(2000);
		GoogleMain.search_button(driver).sendKeys(Keys.RETURN);
		driver.close();
	}

	@AfterTest
	public static void afterTest() {
		System.out.println("Test Run Successfully");
	}
	private static void sleep(long i) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
