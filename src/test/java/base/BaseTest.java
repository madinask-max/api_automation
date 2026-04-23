package base;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import utils.ExtentManager;
import utils.ExtentTestManager;

import java.lang.reflect.Method;

public class BaseTest {
	
	protected static ExtentReports extent;
	
	@BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; 
    }
	
	@BeforeMethod
    public void setup(Method method) {
        extent = ExtentManager.getInstance();
        System.out.println(">>> Extent initialized"); 
        ExtentTest test = extent.createTest(method.getName());
        ExtentTestManager.setTest(test);
    }

    @AfterSuite
    public void tearDown() {
    	System.out.println(">>> Extent flush running"); 
        extent.flush();
    }
	
	
}
