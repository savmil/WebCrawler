package provaP3s;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class myProva {
	
	public static void main(String[] args) {
		
		RemoteWebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Valerio\\git\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\posti\\Documents\\GitHub\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saverio\\Desktop\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        
		driver = new ChromeDriver();
		driver.get("https://www.docenti.unina.it");
		
		String pageSource1 = driver.getPageSource();
		System.out.println(pageSource1);
		
		
        List<WebElement> anchorlist = driver.findElementsByTagName("button");
        int rand=2;//(int)(Math.random()*anchorlist.size());
		WebElement anchorc = anchorlist.get(rand);
		anchorc.click();
		
		String pageSource2 = driver.getPageSource();
		System.out.println(pageSource2);
		//System.out.println(pageSource);
		
		/*
        for(int i=0; i<10; i++){
	        driver.get("https://www.seleniumhq.org/docs/");
	        List<WebElement> anchorlist = driver.findElementsByTagName("a");
	        int rand=(int)(Math.random()*anchorlist.size());
			WebElement anchorc = anchorlist.get(rand);
			anchorc.click();
        } */
        
		//HTMLtoXML();
	}
	
	/*public static void HTMLtoXML(){
		
		RemoteWebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Valerio\\git\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\posti\\Documents\\GitHub\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saverio\\Desktop\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.unina.it");
		String pageSource = driver.getPageSource();
	       
        System.out.println(pageSource);
       
        
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
        catch(IOException e){
        	
        }
        catch(JDOMException e){
        	
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
        
        
        
        //driver.close();
        //driver.quit();
        
        
        /*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
               DocumentBuilder builder = dbf.newDocumentBuilder();
               Document document = builder.parse(pageSource);//dovrebbe essere una verisione xml del file il problema � salvarlo come oggetto
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

//}
