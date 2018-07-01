package crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import net.bytebuddy.dynamic.scaffold.MethodGraph.NodeList;

import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
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
        WebElement event = driver.findElementByXPath(element.getXPath()); // dobbiamo fare in modo tale che un element sia un Web element altrimenti non è cliccabile
        event.click();
        return null;
      
	}
	@Override
	public String load(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		String HTMLPageSource = driver.getPageSource();
		String xmls = new String();
		
		
		 try
	        {
	        	StringReader xml = new StringReader(HTMLPageSource);
	        	SAXBuilder sb = new SAXBuilder();
	        	org.jdom2.Document doc= sb.build(xml);
	        	XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

	            FileWriter fwOutXml = new FileWriter("output.xml");
	        	BufferedWriter bwOutXml = new BufferedWriter(fwOutXml);
	        	outputter.output((org.jdom2.Document) doc, bwOutXml);
	        	xmls=outputter.outputString(doc);
	        }
	        catch(IOException e)
	        {
	        	
	        }
	        catch(JDOMException e)
	        {
	        	
	        }
		
        /*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
               DocumentBuilder builder = dbf.newDocumentBuilder();
               Document document = builder.parse(HTMLPageSource);//dovrebbe essere una verisione xml del file il problema è salvarlo come oggetto
               
        } catch (SAXException sxe) {
               Exception  x = sxe;
               if (sxe.getException() != null)
                      x = sxe.getException();
               x.printStackTrace();
        } catch (ParserConfigurationException pce) {
               pce.printStackTrace();
        } catch (IOException ioe) {
               ioe.printStackTrace();
        }*/

		return xmls;
	}

	


}
