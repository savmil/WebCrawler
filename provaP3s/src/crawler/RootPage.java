package crawler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public abstract class RootPage extends VisitedPage{
	
	private ArrayList<Element> elementList;
	
	public RootPage(String url) {
		super(url);
	}
	public RootPage(String url, String xmlDescr) {
		super(url,xmlDescr);
	}
	
	public ArrayList<Element> getElements() {
		return elementList;
	}
	public void setElements(ArrayList<Element> elements) {
		this.elementList = elements;
	}
	
	public void loadElements()
	{
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//System.out.println(super.getXmlDescr());
			
			String[] xml=super.getXmlDescr().split("<!DOCTYPE html>");			
			System.out.print(xml[1].length());
			Document doc = dBuilder.parse(new InputSource(new StringReader(xml[1])));
			
			NodeList nList = doc.getElementsByTagName("a");
			System.out.println(nList.getLength());
			 /* SAXBuilder builder = new SAXBuilder();
			  System.out.println("qui");
			  Document xmlDocument =new Document(super.getXmlDescr());
			  org.jdom2.Element root = xmlDocument.getRootElement();
			  //org.jdom2.filter.ElementFilter filtera = new org.jdom2.filter.ElementFilter("a");
			  System.out.println(root.getChildren("a").get(0).toString());
			  for(org.jdom2.Element c : root.getChildren("a")) 
			  {
				  Element anchor =new AnchorLink();
				  System.out.println(c.getName());
				  anchor.setValue(c.getAttributeValue("value"));
				  anchor.setXPath(c.getAttributeValue("xpath"));
				  elementList.add(anchor);
			  }
			  org.jdom2.filter.ElementFilter filterb = new org.jdom2.filter.ElementFilter("button");
			  for(org.jdom2.Element c : root.getChildren("button")) 
			  {
				  System.out.println(c.getName());
				  Element button =new Button();
				  button.setValue(c.getAttributeValue("value"));
				  button.setXPath(c.getAttributeValue("xpath"));
				  elementList.add(button);
			  }
			} catch(JDOMException e) {
			  e.printStackTrace();
			} catch(IOException e) {
			  e.printStackTrace();
			}*/
		

	}
	catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
	

