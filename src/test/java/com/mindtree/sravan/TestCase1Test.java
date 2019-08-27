package com.mindtree.sravan;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.sravan.baseclass.BaseDriverClass;

import pageObjects.FlightBooking;
import pageObjects.FlightConfirmationFinal;
import pageObjects.HomePage;
import pageObjects.PassengerDetails;

public class TestCase1Test extends BaseDriverClass {

	HomePage hp;
	FlightBooking fb;
	PassengerDetails pd;
	FlightConfirmationFinal fcf;
	public String flightname;

	@BeforeTest
	public void setUp() throws IOException {
		init();
	}

	@Test(priority = 1)
	public void Login() {
		System.out.println(driver.getTitle());
		hp = new HomePage(driver);
		hp.enterUsername("sravantest");
		hp.pwd("test");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		hp.SignInButton();
	}

	@Test(priority = 2)
	public void FFinder() {
		fb = new FlightBooking(driver);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		fb.FlightFinder();
		fb.FlightConfirm();
	}

	@Test(priority = 3)
	public void FConfirm() {
		fb = new FlightBooking(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i = 3; i <= 9; i++) {
		  flightname=driver.findElement(By.xpath("//table[2]//tbody[1]//tr[" + i + "]//td[2]")).getText();
			if(flightname.equalsIgnoreCase("Pangea Airlines 632"))
			{
			driver.findElement(By.xpath("//table[2]//tbody[1]//tr["+i+"]//input")).click();
			}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			i = i + 1;
		}
       fb.confirm1();
	}
	
	@Test(priority=4)
	public void BuyTickets()
	{
		pd=new PassengerDetails(driver);
		pd.enterPassDetails();
		pd.BuyTick();
	}
	
	
	@Test(priority=5)
	public void TicketConfirm()
	{
		fcf=new FlightConfirmationFinal(driver);
		List<WebElement> det= fcf.GetDetails();
		for(WebElement d:det)
		{
			System.out.println(d.getText());
		}
	}
	
	@Test(priority=6)
	public void Logout()
	{
		fcf.logout();
	}
	
	@AfterTest
	public void Kill()
	{
		killBrowser();
	}
	

}
