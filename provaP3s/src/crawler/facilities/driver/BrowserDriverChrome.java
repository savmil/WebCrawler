package crawler.facilities.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriverChrome extends BrowserDriver {
	
	public BrowserDriverChrome()
	{
		super("webdriver.chrome.driver","selenium\\chromedriver.exe");
		//this.driver = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		this.driver = new ChromeDriver(options);
		
	}
}
