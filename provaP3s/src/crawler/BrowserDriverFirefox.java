package crawler;

import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFirefox extends BrowserDriver{
	
	public BrowserDriverFirefox(){
		//super("webdriver.gecko.driver","C:\\Users\\Valerio\\git\\WebCrawler\\provaP3s\\selenium\\geckodriver.exe");
		//super("webdriver.chrome.driver", "C:\\Users\\posti\\Documents\\GitHub\\WebCrawler\\provaP3s\\selenium\\geckodriver.exe");
		super("webdriver.gecko.driver", "C:\\Users\\Saverio\\Desktop\\WebCrawler\\provaP3s\\selenium\\geckodriver.exe");
		this.driver = new FirefoxDriver();
	}
}
