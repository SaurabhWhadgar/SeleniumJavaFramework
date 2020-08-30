package testng.udemy.learn;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngAnnotation {

	private static WebDriver driver;
	static WebElement element;
		
	@BeforeTest
	public static void testStart() {
		System.out.println("Test started");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Parameters({"userText"})
	@Test(priority = 2)
	public static void negativeTest(String userText) {
		driver.get("http://www.google.com");
		element = driver.findElement(By.xpath("//input[@name='q']"));
		element.sendKeys(userText);
		
	}
	
	@Parameters({"userText"})
	@Test(priority = 1)
	public static void positiveTest(String userText) {
		driver.get("http://www.google.com");
		element = driver.findElement(By.xpath("//input[@name='q']"));
		element.sendKeys(userText);
		
	}
	
	@Test(priority = 3)
	public static void groupTest() {
		driver.get("http://www.google.com");
		driver.navigate().to("http://www.webmail.ibab.in");
	}
	
	@AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
