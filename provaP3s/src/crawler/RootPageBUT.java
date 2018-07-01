package crawler;

public class RootPageBUT extends RootPage{

	public RootPageBUT(String url) {
		super(url);
	}
	public RootPageBUT(String url, String xmlDescr) {
		super(url,xmlDescr);	
	}
	public RootPageBUT(String url, String xmlDescr,BrowserDriver driver) {
		super(url,xmlDescr,driver);
		
	}
}