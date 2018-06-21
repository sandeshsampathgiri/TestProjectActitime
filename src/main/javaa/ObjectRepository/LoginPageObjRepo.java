package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjRepo {
	
	WebDriver driver;
	
	By username=By.xpath("//input[@name='username']");
	By password=By.xpath("//input[@type='password']");
	By submitBtn=By.xpath("//button[@type='submit']");
	
	public LoginPageObjRepo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement enterUsername()
	{
	return driver.findElement(username);
	}
	
	public WebElement enterPassword()
	{
	return driver.findElement(password);
	}
	
	public WebElement loginBtnClick()
	{
	return driver.findElement(submitBtn);
	}
}
