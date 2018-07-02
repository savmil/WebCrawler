package crawler;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.JDOMException;
import org.jdom2.filter.ElementFilter;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.DOMOutputter;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathHelper;
import org.w3c.dom.NodeList;


public abstract class RootPage extends VisitedPage{
	
	private ArrayList<Element> elementList;
	
	public RootPage(String url) {
		super(url);
	}
	public RootPage(String url, String xmlDescr) {
		super(url,xmlDescr);
		elementList=new ArrayList<Element>();
	}
	
	public ArrayList<Element> getElements() {
		return elementList;
	}
	public void setElements(ArrayList<Element> elements) {
		this.elementList = elements;
	}
	
	public void loadElements()
	{
		//try {
			//DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			//DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//System.out.println(super.getXmlDescr());
			try
	        {
				//System.out.print(super.getXmlDescr());
				String xml=super.getXmlDescr().replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +"<!DOCTYPE html>", "");			
				//System.out.print(xml);
	        	StringReader doc = new StringReader(xml);
	        	SAXBuilder sb = new SAXBuilder();
	        	org.jdom2.Document document= sb.build(doc);
	        	org.jdom2.Element root = document.getRootElement();
	        	ElementFilter filtera = new org.jdom2.filter.ElementFilter("a");
	        	for(org.jdom2.Element c : root.getDescendants(filtera)) {
	        		Element anchor=new AnchorLink();
	        		anchor.setValue(c.getAttributeValue("value"));
	        		String xPath="";
	        		//System.out.println(c.toString());
	        		while (!c.toString().equals(root.toString()))
	        		{
	        			String appoggio=c.toString();
	        			appoggio.replace("[Element:", "");
	        			System.out.println(appoggio);
	        			xPath=xPath+c.toString();
	        			c=(org.jdom2.Element) c.getParent();
	        			
	        		}
	        		xPath=xPath+root.toString();
	        		anchor.setXPath(xPath);
	        		elementList.add(anchor);
	        	}
	        	ElementFilter filterb = new org.jdom2.filter.ElementFilter("button");
	        	for(org.jdom2.Element c : root.getDescendants(filterb)) {
	        		Element button=new Button();
	        		button.setValue(c.getAttributeValue("value"));
	        		String xPath="";
	        		//System.out.println(c.toString());
	        		while (!c.toString().equals(root.toString()))
	        		{
	        			xPath=xPath+c.toString();
	        			c=(org.jdom2.Element) c.getParent();
	        			
	        		}
	        		xPath=xPath+root.toString();
	        		button.setXPath(xPath);
	        		elementList.add(button);
	        	}
	        	//System.out.println(document.getRootElement().getChild("a").getText());
	        	//DOMOutputter outputter = new DOMOutputter();
	        	//org.w3c.dom.Document Doc= outputter.output(document);
	        	//NodeList anchors =Doc.getElementsByTagName("a");
	        	//NodeList buttons =Doc.getElementsByTagName("button");
	        	//System.out.println(anchors.getLength());
	        	//System.out.println(buttons.getLength());
	        	/*for (int i=0;i<=anchors.getLength();i++)
	        	{
	        		AnchorLink anchor=new AnchorLink();
	        		System.out.println(anchors.item(i).toString());
	        		anchor.setXPath(anchors.item(i).toString());
	        		elementList.add(anchor);
	        	}
	        	for (int i=0;i<=buttons.getLength();i++)
	        	{
	        		Button button=new Button();
	        		System.out.println(buttons.item(i).toString());
	        		button.setXPath(buttons.item(i).toString());
	        		elementList.add(button);
	        	}*/
	        }
	        catch(IOException e)
	        {
	        	
	        }
	        catch(JDOMException e)
	        {
	        	
	        }
			
			//org.jdom2.Document doc = dBuilder.parse(new StringReader(xml));
			
			//NodeList nList = doc.getElementsByTagName("a");
			//System.out.println(nList.getLength());
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
		
			/*catch (Exception e) 
			{
				e.printStackTrace();
			}
		}*/
	}
	
}
	

