package com.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		if (driver==null) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.google.com");
		}
	}

	@Test
	public void searchGoogle1() {
		driver.findElement(By.name("q")).sendKeys("selenium");
	}

	@Test
	public void searchGoogle2() {
		driver.findElement(By.name("q")).sendKeys("selenium");
		Assert.assertEquals(12,13);
	}

	@AfterMethod

	public void tearDown() {

		if (driver != null) {
			driver.quit();
			driver=null;
		}
	}

}
