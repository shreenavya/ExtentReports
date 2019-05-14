package com.test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")	;
		
		
		ExtentHtmlReporter html=new ExtentHtmlReporter(new File("C:\\Users\\admin\\Desktop\\Navya\\test15.html"));
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Test yantra");
		html.config().setReportName("Regression test suite");
		
		ExtentReports ex=new ExtentReports();
		ex.attachReporter(html);
		ex.setSystemInfo("Enivornment", "Test");
		ex.setSystemInfo("Eng_name", "navya");
		ex.setSystemInfo("Build_no", "1.2");
		ex.setSystemInfo("platform", "window 10");
		ExtentTest test=ex.createTest("Homepage");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		test.log(Status.PASS, "browser-chromedriver");
		
		
		driver.get("https://www.seleniumhq.org/");
		String act = driver.getTitle();
		String expect="Selenium - web Browser Automation";
		if(act.equals(expect))
		{
			test.log(Status.PASS, "navigated to the target url");
		}
		else
			test.log(Status.FAIL, "url is not working");
		driver.close();
		ex.flush();
	}

}
