package crawler.entity.pages;

public abstract class VisitedPage {
	private String url;
	private String xmlDescr;
	
	public VisitedPage(String url) {
		super();
		this.url = url;
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
	public void setXmlDescr(String xmlDescr) {
		this.xmlDescr = xmlDescr;
	}
	
	
}
