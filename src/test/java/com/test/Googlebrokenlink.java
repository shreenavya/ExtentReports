package com.test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Googlebrokenlink {
	//a[contains(.,'java')]
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe")	;
		ExtentHtmlReporter html=new ExtentHtmlReporter(new File("C:\\Users\\admin\\Desktop\\Navya\\test2.html"));
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	//	driver.findElement(By.xpath("//input[@name='q']"));
		List<WebElement> links=driver.findElements(By.xpath("//a[@href]"));
		for(WebElement l:links)
		{
		String ref = l.getAttribute("href");
		URL u=new URL(ref);
		HttpURLConnection con = (HttpURLConnection)	u.openConnection();
		int rcode = con.getResponseCode();
		if(rcode==200)
		{
			test.log(Status.PASS, "Link is not broken");
		}
		else
		{
			test.log(Status.PASS, "Link is broken");
		}
		
		
		}
		
		driver.close();
		ex.flush();
	}

}
