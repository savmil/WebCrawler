package crawler.entity.pages;

import crawler.entity.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.SaslException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class RootPage extends VisitedPage{
	
	private ArrayList<Element> elementList;
	
	public RootPage(String url) {
		super(url);
		elementList=new ArrayList<Element>();
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
	

}
	

