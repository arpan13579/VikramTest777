package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 WebDriver driver;
    
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	// WebElements
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement Signin;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement Home;
	
	@CacheLookup
	@FindBy(xpath="//a[contains(text(),'Flights')]")
	WebElement FlightsHome;
	
	
	//Methods
	
	public void enterUsername(String name)
	{
		username.sendKeys(name);
	}
	
	public String GetUsername()
	{
		return username.getAttribute("userName");
	}
	
	public String GetPwd()
	{
		return pwd.getAttribute("password");
	}
	
	public void pwd(String pwd1)
	{
		pwd.sendKeys(pwd1);
	}
	public void clickHome()
	{
		Home.click();
	}
	
	
	public void FlightsLink()
	{
		FlightsHome.click();
	}
	
	
	public void SignInButton()
	{
		Signin.click();
	}
	
	
	public void login(String user1,String pwd1)
	{
		this.enterUsername(user1);
		this.pwd(pwd1);
		this.SignInButton();
	}
	
	
	
}
