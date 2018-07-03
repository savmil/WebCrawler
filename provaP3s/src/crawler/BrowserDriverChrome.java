package crawler;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriverChrome extends BrowserDriver {
	
	public BrowserDriverChrome()
	{
		super("webdriver.chrome.driver","selenium\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
}
