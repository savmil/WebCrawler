package crawler;

public class RootPageBM extends RootPage{

	public RootPageBM(String url) {
		super(url);
	}
	public RootPageBM(String url, String xmlDescr) {
		super(url,xmlDescr);	
	}
	public RootPageBM(String url, String xmlDescr,BrowserDriver driver) {
		super(url,xmlDescr,driver);
		
	}

}