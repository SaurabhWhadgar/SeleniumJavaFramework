package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FreeCrm {
	@Test
	public void loginTest() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String baseUrl = "http://www.freecrm.com";
		
		try {
			driver.get(baseUrl);
		} catch ( WebDriverException e) {
			// TODO: handle exception
			System.out.println("Network Not Reachable");
		}
		
		driver.close();
	}
}
