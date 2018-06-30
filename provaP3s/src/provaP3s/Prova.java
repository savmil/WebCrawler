package provaP3s;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.XMLReader;
public class Prova 
{
	//**********************
	// vedete questo commento???
	//**************
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saverio\\Desktop\\chromedriver.exe");
        RemoteWebDriver driver = new ChromeDriver();  
        driver.get("https:\\www.ansa.it"); 
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Saverio\\Desktop\\geckodriver.exe");
        RemoteWebDriver driverf = new FirefoxDriver();
        System.out.println("sono qui");
        driverf.get("https:\\www.ansa.it"); 
        List<WebElement> anchorlist=null;
        List<WebElement> anchorlistf=null;
        WebDriverWait wait1 = new WebDriverWait(driver,30);
        WebDriverWait wait2 = new WebDriverWait(driverf,30);
        XMLReader r = new MySAXDriver();

        // try to activate validation
try {
r.setFeature("http://xml.org/sax/features/validation", true);
} catch (SAXException e) {
System.err.println("Cannot activate validation."); 
}

        // register event handlers
r.setContentHandler(new MyContentHandler());
r.setErrorHandler(new MyErrorHandler());

        // parse the first document
try {
r.parse("http://www.foo.com/mydoc.xml");
} catch (IOException e) {
System.err.println("I/O exception reading XML document");
} catch (SAXException e) {
System.err.println("XML exception reading document.");
}
        // namespaces - DocumentBuilderFactory is *not* namespace aware by default
       System.out.println(driver.getPageSource());
      
       do
        {
        	anchorlist=driver.findElementsByTagName("a");
        	WebElement anchorc=null;
        	WebElement anchorf=null;
        	int rand=0;
        	//System.out.println("qui");
        	if (anchorlist.size()!=0)
        	{
        		do
        		{	
        			System.out.println("size c"+anchorlist.size());
        			
        			rand=(int)(Math.random()*anchorlist.size());
        			anchorc=anchorlist.get(rand);
        		}
        		while(!anchorc.isEnabled());
     
        		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-body")));
        		try
        		{
        			
        			System.out.println("chrome");
        			 
        			anchorc.click();
        			System.out.println("chrome click");
        		}
        		catch(ElementNotInteractableException e)
        		{
        			e.printStackTrace();
        		}
        
        		anchorlistf=driverf.findElementsByTagName("a");
        		anchorf=anchorlistf.get(rand);
        		
        		new WebDriverWait(driverf, 5000).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        		System.out.println(anchorf.toString());
        		wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-body")));
        		System.out.println("size f"+anchorlistf.size());
        		try
        		{
        			System.out.println("firefox ");
        			anchorf.click();
        			System.out.println("firefox click");
        		}
        		catch(ElementNotInteractableException e)
        		{
        			e.printStackTrace();
        		}
        		
        	}
        	
        }
        while(anchorlist.size()!=0);
       System.out.println("qui");
       /* do
        {
        	anchorlist=driverf.findElements(ByTagName.tagName("a"));
        	System.out.println(anchorlist.size());
        	if (anchorlist.size()!=0)
        	{
        		WebElement anchorc=anchorlist.get((int)(Math.random()*anchorlist.size()));
        		anchorc.click();
        	}
        }
        while(anchorlist.size()!=0);*/
	}
}
