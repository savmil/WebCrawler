package crawler;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFirefox extends BrowserDriver{
	
	public BrowserDriverFirefox(){
		super("webdriver.gecko.driver","selenium\\geckodriver.exe");
		this.driver = new FirefoxDriver();
	}
}
