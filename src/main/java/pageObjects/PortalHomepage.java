package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomepage {
	
	public WebDriver driver;
	
	//By searchbox=By.name("query");
	By login=By.xpath("//input[@type='submit']");
	

	//Constructor
	public PortalHomepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	/*
	public WebElement getSearchbox()
	{
		return driver.findElement(searchbox);
		
	}
	*/
	public WebElement getLogin()
	{
		return driver.findElement(login);
		
	}

}
