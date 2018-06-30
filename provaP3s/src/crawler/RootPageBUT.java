package crawler;

import javax.xml.crypto.dsig.XMLObject;

public class RootPageBUT extends RootPage{

	public RootPageBUT(String url) {
		super(url);
	}
	public RootPageBUT(String url, XMLObject xmlDescr) {
		super(url,xmlDescr);	
	}
}