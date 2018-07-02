package crawler;

public class LoadThread extends Thread {
	private RootPage rootP;
	private BrowserDriver driver;
	
	public LoadThread(RootPage rootP, BrowserDriver driver) {
		super();
		this.rootP = rootP;
		this.driver = driver;
	}

	public void run(){
		String xml = driver.load(rootP.getUrl());
		rootP.setXmlDescr(xml);
	}
}
