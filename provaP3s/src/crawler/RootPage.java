package crawler;

import java.util.ArrayList;

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
	
	public void loadElements(){

	}
}
	

