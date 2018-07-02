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
		String xmlBM = driver.load(rootP.getUrl());
		rootP.setXmlDescr(xmlBM);
	}
	
	/* CODICE DA METTERE IN CRAWLERMANAGER
	RootPage rootBM = new RootPageBM(rootURL);
	RootPage rootBUT = new RootPageBUT(rootURL);
	Thread workerBM = new LoadThread(rootBM,driverBM);
	Thread workerBUT = new LoadThread(rootBUT,driverBUT);
	workerBM.start();
	workerBUT.start();
	
	try {
		workerBM.join();
		workerBUT.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} */
}
