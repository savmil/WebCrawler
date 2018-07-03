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
		System.out.println(this.getName() + ": Avvio la ricarica della pagina.");
		String xmlBM = driver.load(rootP.getUrl());
		System.out.println(this.getName() + ": Pagina ricaricata con successo.");
		rootP.setXmlDescr(xmlBM);
		System.out.println(this.getName() + ": Avvio la ricarica degli elementi.");
		rootP.loadElements();
		System.out.println(this.getName() + ": Elementi ricaricati con successo.");
	}
}
