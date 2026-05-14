package listeners;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

public class TestListener implements ITestListener {
	

	 private static final List<String> failedTests =
	            new ArrayList<>();

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        System.out.println("PASSED : "
	                + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {

	        String failedTest =
	                result.getTestClass().getName()
	                + " -> "
	                + result.getMethod().getMethodName();

	        failedTests.add(failedTest);

	        System.out.println("FAILED : " + failedTest);

	        System.out.println(result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {

	    	
	    	
	        System.out.println("\n=================================");
	        System.out.println("FAILED TESTS SUMMARY");
	        System.out.println("=================================");

	        if (failedTests.isEmpty()) {

	            System.out.println("No Failed Tests");

	        } else {

	            for (String test : failedTests) {

	                System.out.println(test);
	            }
	        }

	        System.out.println("=================================\n");
	        ExtentManager.getInstance().flush();
	        
	    }
}