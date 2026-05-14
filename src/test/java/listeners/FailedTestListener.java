package listeners;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedTestListener implements ITestListener{

	 private static List<String> failedTests = new ArrayList<>();

	    @Override
	    public void onTestFailure(ITestResult result) {

	        failedTests.add(
	            result.getTestClass().getName()
	            + " -> "
	            + result.getMethod().getMethodName()
	        );
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
	    }
	
	
}
