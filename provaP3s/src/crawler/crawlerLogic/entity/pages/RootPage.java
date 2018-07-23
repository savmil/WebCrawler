package crawler.crawlerLogic.entity.pages;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import crawler.crawlerLogic.entity.*;


public class RootPage extends VisitedPage{
	
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
	public void saveVisitedPage(String dir)
	{
		try
		{
			PrintWriter rootPage = new PrintWriter (dir+"\\root.xml");
			rootPage.write(this.getXmlDescr());
			rootPage.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	

}
	

