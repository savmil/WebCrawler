package crawler.facilities.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverChrome extends BrowserDriver {
	
	public BrowserDriverChrome()
	{
		super("webdriver.chrome.driver","selenium\\chromedriver.exe");
		
	}
	
	public RemoteWebDriver getDriver(){
		return new ChromeDriver();
	}
}
