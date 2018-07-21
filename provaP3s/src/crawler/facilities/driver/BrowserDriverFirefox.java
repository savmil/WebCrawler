package crawler.facilities.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverFirefox extends BrowserDriver{
	
	public BrowserDriverFirefox(){
		super("webdriver.gecko.driver","selenium\\geckodriver.exe");
	}

	protected RemoteWebDriver getDriver() {
		return new FirefoxDriver();
	}
}
