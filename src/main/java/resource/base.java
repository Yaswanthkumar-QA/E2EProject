package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		//chrome
		//firefox
		//IE
		prop=new Properties();
		//System.getProperty("user.dir") // This gives the path until E2EProject
		//FileInputStream fis=new FileInputStream("F:\\work\\Software Installed\\eclipse\\eclipse_workspace\\E2EProject\\src\\main\\java\\resource\\data.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			//execute in chrome driver
			System.setProperty("webdriver.chrome.driver", "F:\\work\\WebDriver\\chromedriver.exe");
			//driver=new ChromeDriver();
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
				// Project executing in chrome headless mode ie., browser invocation is not happen in headless mode
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			
		}
		else if(browserName=="firefox")
		{
			//execute in firefox driver
			System.setProperty("webdriver.firefox.driver", "F:\\work\\WebDriver\\geckodriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName=="msedge")
		{
			//execute in edge driver
			System.setProperty("webdriver.edge.driver", "F:\\work\\WebDriver\\msedgedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String TestCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
