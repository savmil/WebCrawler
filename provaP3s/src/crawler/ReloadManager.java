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
		System.out.println("[ReloadManager]: Start reload");
		Thread workerBM = new ReloadThread(rootBM,driverBM);
		Thread workerBUT = new ReloadThread(rootBUT,driverBUT);
		workerBM.start();
		workerBUT.start();
		
		try {
			workerBM.join();
			workerBUT.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
