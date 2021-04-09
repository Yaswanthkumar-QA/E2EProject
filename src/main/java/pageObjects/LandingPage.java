package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By login=By.xpath("//nav[@class='pull-right']/ul/li[4]/a");
	//private By login=By.cssSelector("a[href*='sign_in']");
	private By title=By.xpath("//*[@id=\"content\"]/div/div/h2");
	private By navbar=By.cssSelector(".nav.navbar-nav.navbar-right");
	private By links=By.tagName("a");
	private By popup=By.xpath("//button[text()='NO THANKS']");

	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	
	public WebElement getLogin()
	{
		/*driver.findElement(login).click();
		LoginPage login=new LoginPage(driver);
		return login;
		*/
		return driver.findElement(login);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	
	public WebElement getNavbar()
	{
		return driver.findElement(navbar);
	}
	
	public WebElement getLinks()
	{
		return driver.findElement(links);
	}
	
	public int getPopupSize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}

}
