package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBooking {

WebDriver driver;
    
	public FlightBooking(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@name='passCount']")
	WebElement NoPassengers;
	
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement Depart;
	
	@FindBy(xpath="//select[@name='fromMonth']")
	WebElement depMonth;
	
	@FindBy(xpath="//select[@name='fromDay']")
	WebElement depDate;
	
	@FindBy(xpath="//select[@name='toPort']")
	WebElement retPlace;
	
	@FindBy(xpath="//select[@name='toDay']")
	WebElement retDate;
	
	@FindBy(xpath="//select[@name='airline']")
	WebElement chooseAirline;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement findflightsButton;
	
	@FindBy(xpath="//select[@name='toMonth']")
	WebElement retMonth;
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	WebElement FlightConfirm1;
	
	
   public void Select(WebElement w,String value)
   {
	   Select Common = new Select(w);
	   Common.selectByVisibleText(value);
   }
	
	public void FlightFinder()
	{
		Select(NoPassengers,"1");
		Select(Depart,"Frankfurt");
		Select(depMonth,"September");
		Select(depDate,"1");
		Select(retPlace,"London");
		Select(retMonth,"September");
		Select(retDate,"3");
		Select(chooseAirline,"Unified Airlines");
	}
	
	public void FlightConfirm()
	{
		findflightsButton.click();
	}
	
	
	public void RadioComm(WebElement r)
	{
		if(r.isSelected()==false)
		{
			r.click();
		}
		else if(r.isSelected()==true)
		{
			System.out.println("already selected...");
		}
			
	}
	
	public void confirm1()
	{
		FlightConfirm1.click();
	}
	
	
}
