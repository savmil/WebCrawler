package crawler;

import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class RootPage extends VisitedPage{
	
	
	private ArrayList<Element> elementList;
	private BrowserDriver driver;
	public RootPage(String url) {
		super(url);
	}
	public RootPage(String url, String xmlDescr) {
		super(url,xmlDescr);
	}
	public RootPage(String url, String xmlDescr,BrowserDriver driver) {
		super(url,xmlDescr);
		driver=this.driver;
	}
	
	public ArrayList<Element> getElements() {
		return elementList;
	}
	public void setElements(ArrayList<Element> elements) {
		this.elementList = elements;
	}
	
	public void loadElements()
	{
		elementList=driver.findElements();
	}
}
	

