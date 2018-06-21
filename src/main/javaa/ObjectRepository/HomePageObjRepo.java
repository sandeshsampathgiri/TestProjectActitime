package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjRepo {

	WebDriver driver;

	By pipelineHdr = By.xpath("//a[contains(text(),'PIPELINE')]");

	public HomePageObjRepo(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement verifypipelineHdr() {
		return driver.findElement(pipelineHdr);
	}

}
