package crawler;

import javax.xml.crypto.dsig.XMLObject;

public class VisitedPageBM extends VisitedPage{

	public VisitedPageBM(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}
	public VisitedPageBM(String url, XMLObject xmlDescr) {
		super(url,xmlDescr);
	}

}
