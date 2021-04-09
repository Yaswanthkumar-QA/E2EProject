package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.base;



public class LoginTest extends base {
	public WebDriver driver;
	
	private static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intializeBrowser() throws IOException
	{
		driver=initializeDriver();
		
		log.info("Diver is initialized");
	}
	
	
	@Test(dataProvider="getData")
	public void loginPageValidation(String username,String password,String text) throws IOException
	{
		//Creating object to that class and invoke methods of it
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
		LandingPage Landpage=new LandingPage(driver);
		//LoginPage login=Landpage.getLogin();
		Landpage.getLogin().click();
		log.info("Navigated to login page");
		LoginPage login=new LoginPage(driver);
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLogin().click();	
		
		log.info("Login User Details "+text);
		ForgotPassword fp=login.getforgotpwd();
		fp.getEmail().sendKeys("qaclickacademy@qa.com");
		fp.getSubmit().click();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		//Rows stands for how many different data types test should run
		//Column stands for how many values for each test
		Object[][] data=new Object[2][3];
		//0th Row
		data[0][0]="nonrestricteduser@qa.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		
		//1st Row
		data[1][0]="Restricteduser@qa.com";
		data[1][1]="456789";
		data[1][2]="nonrestricted User";
		
	
		return data;
	
	}
	

	@AfterTest
	public void teardown()
	{
		log.info("close the browser");
		driver.close();
	}
	

	

}
