package com.crm.SeleniumProject_Maven.GenericsLib;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListenerS implements ITestListener{
	ExtentReports reports;
	ExtentTest test;

	public void onFinish(ITestContext arg0) {
		reports.flush();

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReports.html");
		reporter.config().setDocumentTitle("SDET21");
		reports=new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "Pre-prod");
		reports.setSystemInfo("Platform", "Window");
		reports.setSystemInfo("Browser Version", "Chrome-93");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getThrowable());
		test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");

		BaseClass baseclass=new BaseClass();
		try {
			String path=	baseclass.getscreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}









}
