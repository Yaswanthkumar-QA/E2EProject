package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;

import resource.base;



public class validateTitle extends base {
	public WebDriver driver;
	
	private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intializebrowser() throws IOException
	{
		driver=initializeDriver();
		log.info("Diver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test
	public void titleValidation()
	{
		
		//Creating object to that class and invoke methods of it
		
		LandingPage Landpage=new LandingPage(driver);
		//Compare text from the browser with actual text
		Assert.assertEquals(Landpage.getTitle().getText(), "FEATURED COURSES");
		//Assert.assertTrue(Landpage.getNavbar().isDisplayed());
		log.info("Validating Title Text in home page is successful");
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		log.info("close the browser");
		driver.close();
	}
	
	
	

}
