package com.qa.testng;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

	static WebDriver driver;

	SoftAssert st = new SoftAssert();

	@BeforeMethod
	public void baseMethod() {
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(400));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	}

	@Test(priority = 0, groups = "loginGroup", expectedExceptions = ArithmeticException.class, enabled = true, invocationCount = 3)
	public void testmethod1() {
		driver.findElement(By.name("proceed")).click();
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		Assert.assertEquals(message, "Please enter a valid user name");
		st.assertAll();
	}

	@Test(priority = 1, dependsOnMethods = { "testmethod1" }, groups = "loginGroup")
	public void testmethod2() {
		driver.findElement(By.name("proceed")).click();
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		Assert.assertEquals(message, "Please enter a valid user name");
		st.assertAll();
	}

	@Test(priority = 2, groups = "SingninGroup")
	public void testmethod3() {
		driver.findElement(By.name("proceed")).click();
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		Assert.assertEquals(message, "Please enter a valid user name");
		st.assertAll();
	}

	@Test(priority = 3, groups = "SingninGroup")
	public void testmethod4() {
		driver.findElement(By.name("proceed")).click();
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		Assert.assertEquals(message, "Please enter a valid user name");
		st.assertAll();
	}

	@Test(priority = 4, groups = "SingninGroup")
	public void testmethod5() {
		driver.findElement(By.name("proceed")).click();
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		Assert.assertEquals(message, "Please enter a valid user name");
		st.assertAll();
	}

	@Test(priority = 5, groups = "SingninGroup")
	public void testmethod() {
		driver.findElement(By.name("proceed")).click();
		Alert alt = driver.switchTo().alert();
		String message = alt.getText();
		Assert.assertEquals(message, "Please enter a valid user name");
		st.assertAll();
	}

	@AfterMethod
	public void tearDownMethod() {
		driver.quit();
	}

}
