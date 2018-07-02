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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BrowserDriver {
	private RemoteWebDriver driver;
	public BrowserDriver(String driver_exe, String config)
	{
		System.setProperty(driver_exe, config);
		
		if (driver_exe.equals("webdriver.chrome.driver")) // l' ho fatta così perchè se passo l' oggetto chromedriver da browser benchmark ottenfo un errore perchè devo settare prima le proprieta e se le setto di non posso farlo perchè devo prima chimare super
		{
			driver=new ChromeDriver();
			
		}
		else if (driver_exe.equals("webdriver.gecko.driver"))
		{
			driver=new FirefoxDriver();
		}

		
	}
	public String load(String url)
	{
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
	public TriggerResult trigger(Element element){
		String result = null;
		boolean isError = false;
		
		try{
			WebElement event = driver.findElementByXPath(element.getXPath()); // dobbiamo fare in modo tale che un element sia un Web element altrimenti non è cliccabile
			event.click();
			result = driver.getPageSource();
			
		}catch(Throwable e){
			String stackTrace = e.toString();
			result = html2xml(stackTrace);
			isError = true;
		}
		
        TriggerResult tResult = new TriggerResult(result,isError);
		return tResult;
	}
	
	private String html2xml(String HTMLPageSource){
		String xmlPage = new String();
		try{
			StringReader xml = new StringReader(HTMLPageSource);
			SAXBuilder sb = new SAXBuilder();
			org.jdom2.Document doc = sb.build(xml);
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			xmlPage = outputter.outputString(doc);
		}catch(IOException e){
			e.printStackTrace();    	
		}catch(JDOMException e){
			e.printStackTrace();
		}
		return xmlPage;
	}

	public ArrayList<Element> findElements()
	{
		List<WebElement> anchors =driver.findElementsByTagName("a");// anchor link
		List<WebElement> buttons =driver.findElementsByTagName("button");// dovrebbe dare i pulsanti da controllare
		ArrayList<Element> elements=new ArrayList<Element>();
		
		for (int i=0;i<=anchors.size();i++)
		{
			AnchorLink anchor=new AnchorLink();
			anchor.setValue(anchors.get(i).getAttribute("value"));
			anchor.setXPath(anchors.get(i).getAttribute("xpath"));
			elements.add(anchor);
		}
		for (int i=0;i<=buttons.size();i++)
		{
			Button button= new Button();
			button.setValue(anchors.get(i).getAttribute("value"));
			button.setXPath(anchors.get(i).getAttribute("xpath"));
			elements.add(button);
		}
		
		
		return elements;
	}
}
