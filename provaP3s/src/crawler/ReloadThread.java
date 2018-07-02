package crawler;

public class ReloadThread extends Thread{
	
	private String url;
	private RootPage rootP;
	private BrowserDriver driver;
	
	
	public ReloadThread(String url, RootPage rootP, BrowserDriver driver) {
		super();
		this.url = url;
		this.rootP = rootP;
		this.driver = driver;
	}

	public void run(){
		String xmlBM = driver.load(url);
		rootP.setXmlDescr(xmlBM);
		rootP.loadElements();
		System.out.println("sono qui");
	}
}
