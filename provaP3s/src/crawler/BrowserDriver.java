package crawler;

import javax.xml.crypto.dsig.XMLObject;

public interface BrowserDriver {
	
	public XMLObject load(String url);
	public VisitedPage trigger(Element element);
}
