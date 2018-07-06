package crawler.driver;

import crawler.entity.AnchorLink;
import crawler.entity.Button;
import crawler.entity.Element;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
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
			System.out.println("sono qui"+anchors.size());
			for (WebElement element:anchors)
			{
				
				Element anchor=new AnchorLink();
				anchor.setXPath(generateXPATH(element, ""));
				anchor.setValue(element.getAttribute("value"));
				elementList.add(anchor);
			}
			List<WebElement> buttons=driver.findElementsByTagName("button");
			for (WebElement element:buttons)
			{
				Element button=new Button();
				button.setXPath(generateXPATH(element, ""));
				button.setValue(element.getAttribute("value"));
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
			WebElement event = driver.findElementByXPath(element.getXPath()); 
			event.click();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			result = driver.getPageSource();
			//result = html2xml(result);
			isError = false;
			//System.out.println("[BrowserDriver][trigger]: evento scatenato con successo.");
			
			tResult = new TriggerResult(result,isError);

		}catch(Throwable e){
			String stackTrace = e.toString();
			result = string2xml(stackTrace);
			tResult = new TriggerResult(result,isError);
			return tResult;
			//System.out.println("[BrowserDriver][trigger]: la stimolazione ha generato un'eccezione.");
		}
		
		return tResult;
		
		
		
	}
	private String generateXPATH(WebElement childElement, String current) {
	    
	    String xpath=new String();
	   /* if(childTag.equals("html")) {
	        return "/html[1]"+current;
	    }*/
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
	    		/*if(childElement.equals(childrenElement)) 
	    		{
	    			return generateXPATH(parentElement, "/" + childTag + "[" + count + "]"+current);
	    		}*/
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
	
	// la funzione riceve in ingresso lo stacktrace (in formato stringa) e restituisce
	// la descrizione XML dello stacktrace (in formato stringa)
	private String string2xml(String stacktrace){
		org.jdom2.Element error = new org.jdom2.Element("error");
		Document doc = new Document(error);
		org.jdom2.Element stack = new org.jdom2.Element("stack");
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		stack.setAttribute(new Attribute("string", stacktrace));
		return outputter.outputString(doc);
	}

}
