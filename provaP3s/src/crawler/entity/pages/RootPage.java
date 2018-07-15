package crawler.entity.pages;

import crawler.entity.*;
import java.util.ArrayList;


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
	

