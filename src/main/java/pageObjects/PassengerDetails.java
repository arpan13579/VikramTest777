package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PassengerDetails {
	
WebDriver driver;
    
	public PassengerDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	// WebElements
	
	@FindBy(xpath="//input[@name='passFirst0']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='passLast0']")
	WebElement lname;
	
	@FindBy(xpath="//input[@name='creditnumber']")
	WebElement CCnum;
	
	@FindBy(xpath="//input[@name='buyFlights']")
	WebElement BuyFligButton;
	
//	@FindBy(xpath="//input[@name='passFirst0']")
//	WebElement fname;
	
	
	public void TextComm(WebElement w,String value)
	{
		w.sendKeys(value);
	}
	
	
	public void enterPassDetails()
	{
		TextComm(fname,"Sravan");
		TextComm(lname,"test1");
		TextComm(CCnum,"423432");
	}
	
	public void BuyTick()
	{
		BuyFligButton.click();
	}
}
