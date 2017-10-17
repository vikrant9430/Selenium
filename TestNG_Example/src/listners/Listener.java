package listners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
		// TODO Auto-generated method stub
		String textMsg = "About to begin executing following method : " + returnMethodName(method.getTestMethod());
		 
		Reporter.log(textMsg, true);
		
	}

	private String returnMethodName(ITestNGMethod testMethod) {
		// TODO Auto-generated method stub
		return testMethod.getRealClass().getSimpleName() + "." + testMethod.getMethodName();
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		String textMsg = "Completed executing following method : " + returnMethodName(method.getTestMethod());
		 
		Reporter.log(textMsg, true);
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("About to begin executing Suite " + suite.getName(), true);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("About to end executing Suite " + suite.getName(), true);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The execution of the main test starts now");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// This is calling the printTestResults method
		 
				printTestResults(result);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// This is calling the printTestResults method
		 
				printTestResults(result);
		
	}

	private void printTestResults(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
		 
		if (result.getParameters().length != 0) {
 
			String params = null;
 
			for (Object parameter : result.getParameters()) {
 
				params += parameter.toString() + ",";
			}
			Reporter.log("Test Method had the following parameters : " + params, true);
		}
 
		String status = null;
		 
		switch (result.getStatus()) {
 
		case ITestResult.SUCCESS:
 
			status = "Pass";
 
			break;
 
		case ITestResult.FAILURE:
 
			status = "Failed";
 
			break;
 
		case ITestResult.SKIP:
 
			status = "Skipped";
 
		}
 
		Reporter.log("Test Status: " + status, true);
 		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("About to begin executing Test " + context.getName(), true);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test " + context.getName(), true);
		
	}

}
