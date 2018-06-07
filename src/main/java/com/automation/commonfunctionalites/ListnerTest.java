package com.automation.commonfunctionalites;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TestMethod Started :"+result.getName());
		
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TestMethod Sucess :"+result.getName());
	}


	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TestMethod Fail :"+result.getName());
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TestMethod Skipped :"+result.getName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("TestSuite Started :"+ context.getName());
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("TestSuite Finshed :"+ context.getName());
	}

}
