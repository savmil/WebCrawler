package crawler.facilities.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriverFirefox extends BrowserDriver{
	
	public BrowserDriverFirefox(){
		super("webdriver.gecko.driver","selenium\\geckodriver.exe");
		//this.driver = new FirefoxDriver();
		
		FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("--headless");
		this.driver = new FirefoxDriver(options);
	}
}
