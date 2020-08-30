package com.facebook.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 
public class FacebookLogin {
 
  	static WebDriver driver;
  	
  	@BeforeTest
  	public static void setUp(){
         	System.out.println("-----This is the beginning of our test !!!-----");
  	  	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
         	driver = new ChromeDriver();
         	driver.manage().window().maximize();
         	driver.get("https://facebook.com/signup");
  	}
  	
  	@Test
  	public void fillForm(){
         	System.out.println("-----Let us start the sign up process!!!-----");
         	/*
         	 * Handling text boxes to enter and clear values
         	 */
         	WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
         	firstName.sendKeys("Sauarabh");
         	WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
         	lastName.sendKeys("Whadgar");
         	WebElement emailID = driver.findElement(By.xpath("//input[@name='reg_email__']"));
         	emailID.sendKeys("whadgar@gmail.com");
         	WebDriverWait wait = new WebDriverWait(driver, 300);
         	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
         	WebElement confirmEmailID = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
         	confirmEmailID.sendKeys("whadgar@gmail.com");
         	WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
         	Password.sendKeys("tunemerjana");
         	Select birthDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
         	birthDay.selectByVisibleText("20");
         	Select birthMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
         	birthMonth.selectByVisibleText("Sep");
         	Select birthYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
         	birthYear.selectByVisibleText("1995");
         	WebElement genderSelect = driver.findElement(By.xpath("//label[@for='u_0_5']"));
         	genderSelect.click();
         	
         	sleep(3000);
         	
         	
  	}
	
	private void sleep(long i) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(i);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearingUp() {
		driver.close();
		driver.quit();
		
	}
}
