package crawler.crawlerLogic.entity.pages;

import java.util.ArrayList;

import crawler.crawlerLogic.entity.*;


public /*abstract*/ class RootPage extends VisitedPage{
	
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
	

}
	

