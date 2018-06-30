package crawler;

public class ReloadManager 
{
	//private BrowserDriverUnderTest driverBUT;
	//private BrowserDriverBenchmark driverBM;
	private RootPageBM rootBM;
	private RootPageBUT rootBUT;
	private String rootURL;
	
	public ReloadManager(String rootURL,RootPageBM RBM,RootPageBUT RBUT) {
		rootBM = RBM;
		rootBUT = RBUT;
		this.rootURL=rootURL;
	}
	
	void Reload(){
		
		Thread workerBM = new ReloadThread(rootURL,rootBM);
		Thread workerBUT = new ReloadThread(rootURL,rootBUT);
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
