package com.mindtree.sravan;

import com.mindtree.sravan.baseclass.BaseDriverClass;

import pageObjects.SignOnPage;
import testProperties.SendMail;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TestCase2Test extends BaseDriverClass{
	
	SignOnPage sop;
	
	@BeforeTest
	public void setUp() throws IOException
	{
		init();
	}
	
	@Test(dataProvider="SearchProvider")
	public void login(String uname,String pwd)
	{
		sop=new SignOnPage(driver);
		//sop.login("Vik","Test");
		sop.login(uname,pwd);
		if(driver.getTitle().contains("reservation")==true)
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			sop.Soff1();
		}
		else if(driver.getTitle().contains("signon")==true)
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			sop.login(uname,pwd);
		}
	}
	
	
	@DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "sravantest", "test" },
            { "Bhupesh", "USA" }
        };
    }
	
	
	@Test()
	public void sendMail()
	{
		SendMail.send("from@gmail.com","xxxxx","to@gmail.com","hello javatpoint","How r u?");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		killBrowser();
	}

}
