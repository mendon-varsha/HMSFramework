package genericUtility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation extends BaseClass implements ITestListener, ISuiteListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Reports");

		report = new ExtentReports();
		report.attachReporter(spark);
		System.out.println("Execution Started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test case pass");
	}

	
	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts = (TakesScreenshot) sdriver;
		String file = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(file,result.getMethod().getMethodName());
		test.log(Status.FAIL, "TestCase Failed");

	}

}
