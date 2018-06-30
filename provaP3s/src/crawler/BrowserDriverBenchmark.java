package crawler;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverBenchmark implements BrowserDriver {
	private RemoteWebDriver driver;
	
	public BrowserDriverBenchmark()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saverio\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
	}
	public VisitedPage trigger(Element element) 
	{	
        WebElement trig=Element; // dobbiamo fare in modo tale che un element sia un Web element altrimenti non � cliccabile
        trig.click();
      
	}
	
	void load(String rootURL){
		driver.get(rootURL);
		
	}

}
