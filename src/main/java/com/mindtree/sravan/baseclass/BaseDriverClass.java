package com.mindtree.sravan.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import testProperties.LoadProperties;

//import resources.TestProps;

public class BaseDriverClass {
	
//.getRunTime().exec();	
	public static WebDriver driver;
	
	public void init() throws IOException
	{
		selectBrowser(LoadProperties.GetBrowser());
		//Log.info("Browser"+TestProps.GetBrowser()+"...got Started");
		getUrl();
	}
	
	public void getUrl() throws IOException
	{
		driver.get(LoadProperties.GetURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void selectBrowser(String name)
	{
		if(name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\RDMV\\Downloads\\chromedriver.exe");
			//log.info("Creating Object of" + browser);
			driver = new ChromeDriver();
		}
		if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			//log.info("Creating Object of" + browser);
			driver = new FirefoxDriver();
		}
		if(name.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			//log.info("Creating Object of" + browser);
			driver = new InternetExplorerDriver();
		}
		
		
	}
	
	
	public void killBrowser()
	{
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
		driver.quit();
		
	}
	
	public static String takesScreenshot(String testname) throws IOException
	{
		File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest= "C:\\Users\\RDMV\\Desktop\\Neon\\eclipse\\"+testname+".png";
		File dest1=new File(dest);
		FileHandler.copy(Src,dest1);
		return dest;
	}
	
}
