package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	
	//By login=By.xpath("//nav[@class='pull-right']/ul/li[4]/a");
	By email=By.id("user_email");
	By submit=By.cssSelector("input[name='commit']");
	

	//Constructor
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
		
	}
	
	
	

}
