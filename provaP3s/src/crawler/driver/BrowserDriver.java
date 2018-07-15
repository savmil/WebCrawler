package crawler.driver;

import crawler.entity.AnchorLink;
import crawler.entity.Button;
import crawler.entity.Element;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public abstract class BrowserDriver {
	
	protected RemoteWebDriver driver;
	
	public BrowserDriver(String driver_exe, String config){
		System.setProperty(driver_exe, config);
	}
	
	// la funzione carica l'URL sul driver e restituisce l'xmlDescriptor (in formato stringa) della pagina
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
				//button.setXPath(generateXPATH(element, ""));
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
		try{
			List<WebElement> listEvent=null;
			System.out.println(element.getClass().toString());
			if(element.getClass().toString().equals("class crawler.entity.AnchorLink"))
			{
				listEvent = driver.findElementsByTagName("a");
			}
			else if(element.getClass().toString().equals("class crawler.entity.Button"))
			{
				listEvent = driver.findElementsByTagName("button"); 
			}
			String xPath=generateXPATH(listEvent.get(element.getId()));
			listEvent.get(element.getId()).click();
			
			
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
			result = driver.getPageSource();
			//result = html2xml(result);
			isError = false;
			//System.out.println("[BrowserDriver][trigger]: evento scatenato con successo.");
			
			
			
			tResult = new TriggerResult(result,isError,xPath);

		}catch(Throwable e){
			String stackTrace = e.toString();
			tResult = new TriggerResult(stackTrace,isError,null);
			return tResult;
			//System.out.println("[BrowserDriver][trigger]: la stimolazione ha generato un'eccezione.");
		}
		
		return tResult;
		
		
		
	}
	private String generateXPATH(WebElement childElement) {
		//System.out.println("inizio xpath");
	    String xpath=new String();
	   /* if(childTag.equals("html")) {
	        return "/html[1]"+current;
	    }*/
	    
	    int count = 0;
	    
	    String childTag = childElement.getTagName();
	    //System.out.println(childTag);
	    while(!childTag.equals("html"))
	    {
	    	//System.out.println("inizio ciclo1");
	    	int i=0;
	    	WebElement parentElement = childElement.findElement(By.xpath("..")); 
	 	    List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
	    	while((i<childrenElements.size() && !childElement.equals(childrenElements.get(i)))) 
	    	{
	    		//System.out.println("inizio ciclo2");
	    		WebElement childrenElement = childrenElements.get(i);
	    		String childrenElementTag = childrenElement.getTagName();
	    		if(childTag.equals(childrenElementTag)) 
	    		{
	    			count++;
	    		}
	    		i++;
	    		/*if(childElement.equals(childrenElement)) 
	    		{
	    			return generateXPATH(parentElement, "/" + childTag + "[" + count + "]"+current);
	    		}*/
	    	}
	    	xpath="/" + childTag + "[" + count + "]"+xpath;
	    	//System.out.println(xpath);
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
	
	// la funzione riceve in ingresso lo stacktrace (in formato stringa) e restituisce
	// la descrizione XML dello stacktrace (in formato stringa)
	

}
