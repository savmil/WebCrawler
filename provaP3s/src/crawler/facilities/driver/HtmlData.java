package crawler.facilities.driver;

import java.util.ArrayList;

import crawler.crawlerLogic.entity.Element;

public class HtmlData 
{
	private String html;
	private ArrayList<Element> elementList;
	public HtmlData()
	{
		
	}
	public HtmlData(String html, ArrayList<Element> elementList) {
		this.html = html;
		this.elementList = elementList;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public ArrayList<Element> getElementList() {
		return elementList;
	}
	public void setElementList(ArrayList<Element> elementList) {
		this.elementList = elementList;
	}

}
