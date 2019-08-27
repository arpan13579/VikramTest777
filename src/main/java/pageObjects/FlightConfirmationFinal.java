package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationFinal {
	
WebDriver driver;
    
	public FlightConfirmationFinal(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	// WebElements
	
	@FindBy(xpath="//td//td//td//td[2]//a[1]//img[1]")
	WebElement HomePage;
	
	@FindBy(xpath="//tr//tr//tr//tr//tr//td[1]")
	List<WebElement> Details;
	

	@FindBy(xpath="//td[3]//a[1]//img[1]")
	WebElement Logout;
	
	
	public List<WebElement> GetDetails()
	{
		return Details;
	}
	
	public HomePage HomePage2()
	{
		HomePage.click();
		return new HomePage(driver);
	}
	
    public HomePage logout()
    {
    	Logout.click();
    	return new HomePage(driver);
    }
}
