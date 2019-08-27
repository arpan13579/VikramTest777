package testProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	public static String GetBrowser() throws IOException 
	{
	   Properties Prop = new Properties();
	   FileInputStream fis=new FileInputStream("C:\\Users\\RDMV\\SeleniumTest\\src\\main\\java\\testProperties\\Test.properties");
	   Prop.load(fis);
	   String browser=Prop.getProperty("Browser");
	   return browser;
	}

	public static String GetURL() throws IOException 
	{
	   Properties Prop = new Properties();
	   FileInputStream fis=new FileInputStream("C:\\Users\\RDMV\\SeleniumTest\\src\\main\\java\\testProperties\\Test.properties");
	   Prop.load(fis);
	   String URL=Prop.getProperty("URL");
	   return URL;
	}

}
