package com.googlesearch.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleMain {
	
	public static WebDriver driver = null;
	public static WebElement element = null;
	
	public GoogleMain() {
		// TODO Auto-generated constructor stub
		System.out.println("We are starting The test");
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		textbox_search(driver);
		search_button(driver);

	}

	public static WebElement textbox_search(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		return element;
		
	}

	public static WebElement search_button(WebDriver driver) {
		element = driver.findElement(By.name("btnK"));
		return element;
	}

}
