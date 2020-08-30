package com.herokuapp.theinternet;

import java.beans.Expression;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HerokuAppAssert {

	static WebDriver driver = null;

	public HerokuAppAssert() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void main(String[] args) {
		loginTest();
	}

	@BeforeTest
	public static void helloMsg() {
		System.out.println("Test Started");
	}

	@Test
	public static void loginTest() {

		String baseUrl = "https://the-internet.herokuapp.com/login";
		driver.get(baseUrl);
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		sleep(1000);
		username.sendKeys("saurabh");
		password.sendKeys("SuperSecretPassword!");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		
		//Username Verification
		
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));
		WebElement username_error = driver.findElement(By.xpath("//div[@id='flash']"));
		String actualErrorMessage = username_error.getText();
		String expectedErrorMessage = "Your username is invalid!";
		System.out.println(actualErrorMessage);
		System.out.println(expectedErrorMessage);
		Assert.assertTrue("Username is Invalid",actualErrorMessage.contains(expectedErrorMessage));
				
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button secondary radius']")));
		//WebElement logoutbutton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		
		/*
		 * // Verification WebElement successMessage =
		 * driver.findElement(By.xpath("//div[@id='flash']")); String expectedMessage =
		 * "You logged out a secure area!"; String actualMessage =
		 * successMessage.getText(); System.out.println(expectedMessage);
		 * System.out.println(actualMessage);
		 * 
		 * //Assert.assertEquals(expectedMessage, actualMessage);
		 * Assert.assertTrue("Log in Error",actualMessage.contains(expectedMessage));
		 */
		//logoutbutton.click();
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

	@AfterTest
	public static void driveStop() {
		driver.close();
	}

}
