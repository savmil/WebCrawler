package crawler;

public class ReloadManager {
	private BrowserDriver driverBUT;
	private BrowserDriver driverBM;
	
	
	public ReloadManager( BrowserDriver driverBM,BrowserDriver driverBUT) {
		super();
		this.driverBUT = driverBUT;
		this.driverBM = driverBM;
	}
	
	void reload(String rootURL,RootPage rootBM,RootPage rootBUT){
		
		Thread workerBM = new ReloadThread(rootURL,rootBM,driverBM);
		Thread workerBUT = new ReloadThread(rootURL,rootBUT,driverBUT);
		workerBM.start();
		workerBUT.start();
		
		try {
			workerBM.join();
			workerBUT.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		driverBM = new BrowserDriverBenchmark();
		XMLObject xmlBM = driverBM.load(rootURL);
		rootBM.setXmlDescr(xmlBM);
		rootBM.loadElements();
	
		//Par ---
		
		driverBUT = new BrowserDriverUnderTest();
		XMLObject xmlBUT = driverBUT.load(rootURL);
		rootBUT.setXmlDescr(xmlBM);
		rootBUT.loadElements();
		*/
	}
}
