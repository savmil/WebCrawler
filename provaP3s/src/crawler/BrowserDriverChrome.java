package crawler;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriverChrome extends BrowserDriver {
	
	public BrowserDriverChrome()
	{
		//super("webdriver.chrome.driver", "C:\\Users\\mario_000\\git\\Psss\\WebCrawler\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
		super("webdriver.chrome.driver","selenium\\chromedriver.exe");
		//super("webdriver.chrome.driver", "C:\\Users\\posti\\Documents\\GitHub\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
		//super("webdriver.chrome.driver", "C:\\Users\\Saverio\\Desktop\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
}
