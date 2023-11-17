package com.qa.testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {

	public WebDriver driver;

	@Parameters("browser")

	@BeforeMethod
	public void beforeTest(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}

	@Test
	public void testmethod1() {
		driver.findElement(By.name("proceed")).click();
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		Assert.assertEquals(message, "Please enter a valid user name");
	}

	@AfterMethod
	public void tearDownMethod() {
		driver.quit();
	}

}
