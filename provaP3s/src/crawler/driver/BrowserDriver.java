package crawler.driver;

import crawler.entity.Element;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public abstract class BrowserDriver {
	
	protected RemoteWebDriver driver;
	
	public BrowserDriver(String driver_exe, String config){
		System.setProperty(driver_exe, config);
	}
	
	// la funzione carica l'URL sul driver e restituisce l'xmlDescriptor (in formato stringa) della pagina
	public String load(String url){
		String HTMLPageSource = new String();
		String xmls = new String();
		try{
			driver.get(url);
			
			HTMLPageSource = driver.getPageSource();
			xmls = html2xml(HTMLPageSource);
		}catch(Throwable e){
			
		}
		
		return xmls;
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
			result = html2xml(result);
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
	
	// serve per rilasciare le risorse
	public void closeDriver(){
		// le due funzioni si comportano allo stesso modo se viene aperta una solo finestra
		//driver.close();
		driver.quit();
	}
	
	// la funzione riceve in ingresso la descrizione HTML della pagina (in formato stringa) e restituisce 
	// la descrizione XML della pagina (in formato stringa)
	private String html2xml(String HTMLPageSource){
/*		String result = new String();
		
		StringReader frInHtml = new StringReader(HTMLPageSource);
		BufferedReader brInHtml = new BufferedReader(frInHtml);
		SAXBuilder saxBuilder = new SAXBuilder();
		//SAXBuilder saxBuilder = new SAXBuilder("org.ccil.cowan.tagsoup.Parser", false);
		XMLOutputter outputter = new XMLOutputter();
		try {
			Document jdomDocument = saxBuilder.build(brInHtml);
		    result = outputter.outputString(jdomDocument);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;*/
		
		Document doc=new Document();
		String xmls = new String();
		try{
			StringReader xml = new StringReader(HTMLPageSource);
			SAXBuilder sb = new SAXBuilder();
        	doc= sb.build(xml);
        	
		}catch(IOException e){
			//e.printStackTrace();        	
		}catch(JDOMException e){
			//e.printStackTrace();     	
		}

    	XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
    	xmls = outputter.outputString(doc);
		return xmls;
		
    	/* Questo codice serve a stampare su un file xml
        FileWriter fwOutXml = new FileWriter("output.xml");
    	BufferedWriter bwOutXml = new BufferedWriter(fwOutXml);
    	outputter.output((org.jdom2.Document) doc, bwOutXml);
    	*/
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
