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
		System.out.println("[ReloadManagerThread]: Pagina ricaricata con successo");
		rootP.setXmlDescr(xmlBM);
		rootP.loadElements();
	}
}
