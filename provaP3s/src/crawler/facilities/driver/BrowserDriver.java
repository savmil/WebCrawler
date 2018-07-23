package crawler.facilities.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import crawler.crawlerLogic.entity.AnchorLink;
import crawler.crawlerLogic.entity.Button;
import crawler.crawlerLogic.entity.Element;


public abstract class BrowserDriver {
	
	protected RemoteWebDriver driver;
	
	public BrowserDriver(String driver_exe, String config){
		System.setProperty(driver_exe, config);
		this.driver = getDriver();
	}
	
	public HtmlData load(String url){
		String HTMLPageSource = new String();
		HtmlData htmlData=new HtmlData();
		try
		{
			driver.get(url);
			HTMLPageSource = driver.getPageSource();
			
			List<WebElement> anchors=driver.findElementsByTagName("a");
			ArrayList<Element> elementList=new ArrayList<Element>();
			
			for (int i=0;i<=anchors.size();i++)
			{
				Element anchor=new AnchorLink();
				anchor.setId(i);
				elementList.add(anchor);
			}
			List<WebElement> buttons=driver.findElementsByTagName("button");
			for (int i=0;i<=buttons.size();i++)
			{
				Element button=new Button();
				button.setId(i);
				elementList.add(button);
			}
			htmlData.setHtml(HTMLPageSource);
			htmlData.setElementList(elementList);
		}
		catch(Throwable e){
			
		}
		return htmlData;
		
	}
	
	public TriggerResult trigger(Element element){
		String result = null;
		boolean isError = true;
		TriggerResult tResult = null;
		String xPath=null;
		try{
			List<WebElement> listEvent=null;
			if(element instanceof AnchorLink)

			{
				listEvent = driver.findElementsByTagName("a");
			}
			else if(element instanceof Button)
			{
				listEvent = driver.findElementsByTagName("button"); 
			}
			xPath=generateXPATH(listEvent.get(element.getId()));
			listEvent.get(element.getId()).click();
			
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			result = driver.getPageSource();
			isError = false;
			
			tResult = new TriggerResult(result,isError,xPath);

		}catch(Throwable e){
			String stackTrace = e.toString();
			tResult = new TriggerResult(stackTrace,isError,xPath);
			return tResult;
		}
		
		return tResult;
		
		
		
	}
	
	private String generateXPATH(WebElement childElement) {
	    String xpath=new String();
	    
	    int count = 0;
	    
	    String childTag = childElement.getTagName();
	    while(!childTag.equals("html"))
	    {
	    	int i=0;
	    	WebElement parentElement = childElement.findElement(By.xpath("..")); 
	 	    List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
	    	while((i<childrenElements.size() && !childElement.equals(childrenElements.get(i)))) 
	    	{
	    		WebElement childrenElement = childrenElements.get(i);
	    		String childrenElementTag = childrenElement.getTagName();
	    		if(childTag.equals(childrenElementTag)) 
	    		{
	    			count++;
	    		}
	    		i++;
	    	}
	    	xpath="/" + childTag + "[" + count + "]"+xpath;
	    	childElement=parentElement;
	    	childTag=childElement.getTagName();
	    }
	    xpath="html"+xpath;
	    return xpath;
	}
	// serve per rilasciare le risorse
	public void closeDriver(){
		// le due funzioni si comportano allo stesso modo se viene aperta una solo finestra
		//driver.close();
		driver.quit();
	}
	
	protected abstract RemoteWebDriver getDriver();
	

}
