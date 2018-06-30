package crawler;

import java.util.ArrayList;

import javax.xml.crypto.dsig.XMLObject;

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
        WebElement trig=Element; // dobbiamo fare in modo tale che un element sia un Web element altrimenti non è cliccabile
        trig.click();
      
	}
	@Override
	public XMLObject load(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		return null;
	}

	


}
