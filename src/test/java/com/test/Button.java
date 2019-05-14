package com.test;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Button {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")	;
		ExtentHtmlReporter html=new ExtentHtmlReporter(new File("C:\\Users\\admin\\Desktop\\Navya\\test1.html"));
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
		driver.get("http://localhost/login.do");
		
		
	}

}
