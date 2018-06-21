package com.qa.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepository.HomePageObjRepo;
import ObjectRepository.LoginPageObjRepo;

public class LoginTest {

	WebDriver driver;
	ChromeOptions options;
	String appURL = "https://devweb.sslproc.com/net/posweb/";
	String username = "demo_shanmugas@spm1.com";
	String password = "Password123";
	LoginPageObjRepo lpo;
	HomePageObjRepo hpo;

	@BeforeMethod
	public void setUp() {
		System.setProperty(
				"webdriver.chrome.driver",
				"\\Java_Selenium\\PulledProject\\TestProjectActitime\\exeFiles\\chromedriver.exe");

		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(options);
		driver.get(appURL);
		lpo = new LoginPageObjRepo(driver);
		hpo = new HomePageObjRepo(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void verify() {

		lpo.enterUsername().sendKeys(username);
		lpo.enterPassword().sendKeys(password);
		lpo.loginBtnClick().click();
		boolean pipelineHdrDisplay = hpo.verifypipelineHdr().isDisplayed();
		Assert.assertTrue(pipelineHdrDisplay);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
