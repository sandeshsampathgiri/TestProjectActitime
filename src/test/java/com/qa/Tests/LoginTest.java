package com.qa.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	ChromeOptions options;
	String appURL="https://www.facebook.com";
	String username="sandesh.giri@gmail.com";
	String password="Indian_1";
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "\\Java_Selenium\\DemoGitRepo\\exeFiles\\chromedriver.exe");
		options=new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(options);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
	}

	@Test
	public void verify()
	{
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
