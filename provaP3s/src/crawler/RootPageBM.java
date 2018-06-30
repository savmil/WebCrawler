package crawler;

import javax.xml.crypto.dsig.XMLObject;

public class RootPageBM extends RootPage{

	public RootPageBM(String url) {
		super(url);
	}
	public RootPageBM(String url, XMLObject xmlDescr) {
		super(url,xmlDescr);	
	}

}
