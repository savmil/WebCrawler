package provaP3s;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class myProva {
	
	public static void main(String[] args) {
		
		RemoteWebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\posti\\Documents\\GitHub\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saverio\\Desktop\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        
        for(int i=0; i<10; i++){
	        driver.get("https://www.seleniumhq.org/docs/");
	        List<WebElement> anchorlist = driver.findElementsByTagName("a");
	        int rand=(int)(Math.random()*anchorlist.size());
			WebElement anchorc = anchorlist.get(rand);
			anchorc.click();
        }
        
	}
	
	public void HTMLtoXML(){
		
		RemoteWebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\posti\\Documents\\GitHub\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saverio\\Desktop\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.docenti.unina.it");
		String pageSource = driver.getPageSource();
	       
        //System.out.println(pageSource);
       
        
        //xmlReader.setContentHandler(handler);
        try
        {
        	StringReader xml = new StringReader(pageSource);
        	
        	        //org.jdom.Document jdomDocument = saxBuilder.build(log);
        	SAXBuilder sb=new SAXBuilder();
        	Document doc=sb.build(xml);
        	XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());

            FileWriter fwOutXml = new FileWriter("output.xml");
        	BufferedWriter bwOutXml = new BufferedWriter(fwOutXml);
        	outputter.output(doc, bwOutXml);
        	String xmls=outputter.outputString(doc);
        	
        	System.out.println(xmls);
        }
        catch(IOException e)
        {
        	
        }
        catch(JDOMException e)
        {
        	
        }
        /* SAXParserFactory factory=SAXParserFactory.newInstance();
         try
        {
        	SAXBuilder sb=new SAXBuilder();

        	
            XMLReader xmlReader=parser.getXMLReader();
            System.out.println("sono qui");
        	xmlReader.parse(pageSource);
        	System.out.println("sono qui");
        	System.out.println(xmlReader.toString());
        }
        catch(SAXException e)
        {
        
        }
        catch(IOException e)
        {
        	
        }
        catch(ParserConfigurationException e)
        {
        	
        }*/
        driver.close();
        driver.quit();
        /*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
               DocumentBuilder builder = dbf.newDocumentBuilder();
               Document document = builder.parse(pageSource);//dovrebbe essere una verisione xml del file il problema è salvarlo come oggetto
               System.out.println(document.toString());
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
		/*String xml = "<message>HELLO!</message>";
		org.jdom.input.SAXBuilder saxBuilder = new SAXBuilder();
		try {
		    org.jdom.Document doc = saxBuilder.build(new StringReader(xml));
		    String message = doc.getRootElement().getText();
		    System.out.println(message);
		} catch (JDOMException e) {
		    // handle JDOMException
		} catch (IOException e) {
		    // handle IOException
		}
		 */
	}

	

}
