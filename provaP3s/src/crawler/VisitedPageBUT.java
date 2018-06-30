package crawler;

import javax.xml.crypto.dsig.XMLObject;

public class VisitedPageBUT extends VisitedPage{
	
	public VisitedPageBUT(String url) {
		super(url);
	}
	public VisitedPageBUT(String url, XMLObject xmlDescr) {
		super(url,xmlDescr);
	}
}
