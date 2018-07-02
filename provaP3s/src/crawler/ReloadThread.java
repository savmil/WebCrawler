package crawler;

public class ReloadThread extends Thread{
	
	private RootPage rootP;
	private BrowserDriver driver;
	
	
	public ReloadThread(RootPage rootP, BrowserDriver driver) {
		super();
		this.rootP = rootP;
		this.driver = driver;
	}

	public void run(){
		String xmlBM = driver.load(rootP.getUrl());
		rootP.setXmlDescr(xmlBM);
		rootP.loadElements();
	}
}
