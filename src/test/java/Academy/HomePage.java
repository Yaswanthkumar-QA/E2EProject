package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import pageObjects.LandingPage;

import resource.base;



public class HomePage extends base {
	public WebDriver driver;
	
	private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intializeBrowser() throws IOException
	{
		driver=initializeDriver();
		log.info("Diver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		
	}
	
	
	@Test
	public void homePageValidation() throws IOException
	{
		//Creating object to that class and invoke methods of it
		
		
		LandingPage Landpage=new LandingPage(driver);
		log.info(Landpage.getTitle());
		log.info("Title is printed");
		log.info("No. of links in a page "+ Landpage.getLinks().getSize());
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		log.info("close the browser");
		driver.close();
	}
	

	

}
