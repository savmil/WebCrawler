package crawler;

import javax.xml.crypto.dsig.XMLObject;

public abstract class VisitedPage {
	private String url;
	private XMLObject xmlDescr;
	
	public VisitedPage(String url) {
		super();
		this.url = url;
	}
	public VisitedPage(String url, XMLObject xmlDescr) {
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
	public XMLObject getXmlDescr() {
		return xmlDescr;
	}
	public void setXmlDescr(XMLObject xmlDescr) {
		this.xmlDescr = xmlDescr;
	}
	
	
}
