package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener
{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	
	public void onStart(ITestContext textcontext) {
		//String timestamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+".html";
		
		sparkreporter = new ExtentSparkReporter(".\\Reports\\"+repName);
		
		sparkreporter.config().setDocumentTitle("EmartReport");
		sparkreporter.config().setReportName("Login");
		sparkreporter.config().setTheme(Theme.DARK);
		
		
		extent= new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "Emart");
		extent.setSystemInfo("operation system", System.getProperty("user.name"));
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
