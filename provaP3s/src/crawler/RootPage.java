package crawler;

import java.util.ArrayList;

import javax.xml.crypto.dsig.XMLObject;

public abstract class RootPage extends VisitedPage{
	
	private ArrayList<Element> elementList;
	
	public RootPage(String url) {
		super(url);
	}
	public RootPage(String url, XMLObject xmlDescr) {
		super(url,xmlDescr);	
	}
	
	public ArrayList<Element> getElements() {
		return elementList;
	}
	public void setElements(ArrayList<Element> elements) {
		this.elementList = elements;
	}
	
	

}
