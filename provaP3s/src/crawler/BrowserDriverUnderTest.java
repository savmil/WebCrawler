package crawler;

import java.util.ArrayList;

import javax.xml.crypto.dsig.XMLObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverUnderTest implements BrowserDriver
{
	private RemoteWebDriver driverf;
	
	public BrowserDriverUnderTest()
	{
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Saverio\\Desktop\\geckodriver.exe");
		 driverf = new FirefoxDriver();
	}
	public VisitedPage trigger(Element element)
	{
        WebElement trig=Element; // dobbiamo fare in modo tale che un element sia un Web element altrimenti non è cliccabile
        trig.click();
	}
	@Override
	public XMLObject load(String url) {
		// TODO Auto-generated method stub
		driverf.get(url);
		return null;
	}



}
