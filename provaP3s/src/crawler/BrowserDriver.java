package crawler;

import java.io.IOException;
import java.io.StringReader;

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
	
	public String load(String url){
		// TODO Auto-generated method stub
		driver.get(url);
		String HTMLPageSource = driver.getPageSource();
		String xmls = html2xml(HTMLPageSource);
		
		return xmls;
	}
	public TriggerResult trigger(Element element){
		String result = null;
		boolean isError = false;
		
		try{
			WebElement event = driver.findElementByXPath(element.getXPath()); 
			event.click();
			result = driver.getPageSource();
			System.out.println("[BrowserDriver][trigger]: evento scatenato con successo.");
		}catch(Throwable e){
			String stackTrace = e.toString();
			System.out.println(e);
			result = string2xml(stackTrace);
			isError = true;
			System.out.println("[BrowserDriver][trigger]: la stimolazione ha generato un'eccezione.");
		}
		
        TriggerResult tResult = new TriggerResult(result,isError);
		return tResult;
	}
	private String html2xml(String HTMLPageSource)
	{
		org.jdom2.Document doc=new Document();	
		try{
			StringReader xml = new StringReader(HTMLPageSource);
			SAXBuilder sb = new SAXBuilder();
        	doc= sb.build(xml);
        	
			        	/*
			            FileWriter fwOutXml = new FileWriter("output.xml");
			        	BufferedWriter bwOutXml = new BufferedWriter(fwOutXml);
			        	outputter.output((org.jdom2.Document) doc, bwOutXml);
			        	*/
			
		}catch(IOException e){
			e.printStackTrace();        	
		}catch(JDOMException e){
			e.printStackTrace();     	
		}
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		return outputter.outputString(doc);
	}
	private String string2xml(String HTMLPageSource){
		org.jdom2.Element error = new org.jdom2.Element("error");
		Document doc = new Document(error);
		org.jdom2.Element stack = new org.jdom2.Element("stack");
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		stack.setAttribute(new Attribute("string", HTMLPageSource));
		/*String xmlPage = new String();
		try{
			StringReader xml = new StringReader(HTMLPageSource);
			SAXBuilder sb = new SAXBuilder();
			org.jdom2.Document doc = sb.build(new InputSource(xml));
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			xmlPage = outputter.outputString(doc);
		}catch(IOException e){
			e.printStackTrace();    	
		}catch(JDOMException e){
			e.printStackTrace();
		}*/
		return outputter.outputString(doc);
	}

}
