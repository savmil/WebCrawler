package crawler.crawlerLogic.entity.pages;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class VisitedPage {
	private String url;
	private String xmlDescr;
	private int id;
	
	public VisitedPage(String url) {
		super();
		this.url = url;
	}
	public VisitedPage(String url, String xmlDescr,int id) {
		super();
		this.url = url;
		this.xmlDescr = xmlDescr;
		this.id = id;
	}
	public VisitedPage(String url, String xmlDescr) {
		super();
		this.url = url;
		this.xmlDescr = xmlDescr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getXmlDescr() {
		return xmlDescr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setXmlDescr(String xmlDescr) {
		this.xmlDescr = xmlDescr;
	}
	public void saveVisitedPage(String directory,int id)
	{
		try
		{
			PrintWriter visitedPage = new PrintWriter (directory+"\\"+id+".xml");
			visitedPage.write(this.getXmlDescr());
			visitedPage.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
