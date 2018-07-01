package crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BrowserDriver {
	
	private RemoteWebDriver driver;
	
	public BrowserDriver(String config, String driver_exe,RemoteWebDriver driver){
		System.setProperty(driver_exe, config);
		driver=this.driver;
	}
	
	public String load(String url){
		// TODO Auto-generated method stub
		driver.get(url);
		String HTMLPageSource = driver.getPageSource();
		String xmls = new String();
				
		try{
			StringReader xml = new StringReader(HTMLPageSource);
			SAXBuilder sb = new SAXBuilder();
			org.jdom2.Document doc= sb.build(xml);
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	        FileWriter fwOutXml = new FileWriter("output.xml");
			BufferedWriter bwOutXml = new BufferedWriter(fwOutXml);
			outputter.output((org.jdom2.Document) doc, bwOutXml);
			xmls=outputter.outputString(doc);
		}catch(IOException e){
			        	
		}catch(JDOMException e){
			        	
		}

		return xmls;
	}
	
	public TriggerResult trigger(Element element){
		WebElement event = driver.findElementByXPath(element.getXPath()); // dobbiamo fare in modo tale che un element sia un Web element altrimenti non � cliccabile
        event.click();
        
        TriggerResult result = new TriggerResult("",false);
        
		return result;
	}
	/*
	public ArrayList<Element> findElements(){
		
		List<WebElement> anchors =driver.findElementsByTagName("a");// anchor link
		List<WebElement> buttons =driver.findElementsByTagName("button");// dovrebbe dare i pulsanti da controllare
		ArrayList<Element> elements=new ArrayList<Element>();
		
		for (int i=0;i<=anchors.size();i++){
			AnchorLink anchor=new AnchorLink();
			anchor.setValue(anchors.get(i).getAttribute("value"));
			anchor.setXPath(anchors.get(i).getAttribute("xpath"));
			elements.add(anchor);
		}
		
		for (int i=0;i<=buttons.size();i++){
			Button button= new Button();
			button.setValue(anchors.get(i).getAttribute("value"));
			button.setXPath(anchors.get(i).getAttribute("xpath"));
			elements.add(button);
		}
		
		return elements;
	}*/
}
