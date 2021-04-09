package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.ExtentReport;
import resource.base;

public class Listeners extends base implements ITestListener{
	
	ExtentTest test;
	 ExtentReports extent=ExtentReport.getReportObject();
	 ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test pass successfully");
		extentTest.get().log(Status.PASS, "Test pass successfully");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//test.fail(result.getThrowable());
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		//Screenshot
		String TestMethodName=result.getMethod().getMethodName();
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(TestMethodName,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
	}
	
	

}
