package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOnPage {
	
WebDriver driver;
    
	public SignOnPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@CacheLookup
	@FindBy(xpath="//input[@name='userName']")
	WebElement UserName;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='password']")
	WebElement Pwd;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='login']")
	WebElement Submit;
	
	@FindBy(xpath="//a[contains(text(),'SIGN-ON')]")
	WebElement Son;
	
	@FindBy(xpath="//tr//tr//tr//tr[1]//td[1]//img")
	WebElement CheckFlag;
	
	@FindBy(xpath="//a[contains(text(),'SIGN-OFF')]")
	WebElement Soff;
	
	public void Soff1()
	{
	   Soff.click();
	}
	
	
	public void setUname(String name)
	{
		UserName.sendKeys(name);
	}
	
	public void setPwd(String pwd)
	{
		Pwd.sendKeys(pwd);
	}
	
	public String getUname()
	{
		return CheckFlag.getAttribute("src");
	}
	
	public void Button()
	{
		Submit.click();
	}
	
	public void Son1()
	{
		Son.click();
	}
	
	
	public void login(String uname,String pwd)
	{
		this.Son1();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		this.setUname(uname);
		this.setPwd(pwd);
		this.Button();
	}
	
	
	
	

}
