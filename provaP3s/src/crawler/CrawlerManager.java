package crawler;

import java.util.List;

public class CrawlerManager 
{

	void startTest(String rootURL,int nStep){
		
		BrowserDriver driverBM =  new BrowserDriverBenchmark();
		BrowserDriver driverBUT = new BrowserDriverUnderTest();
		
		/* Codice sequenziale
		String xmlBM = driverBM.load(rootURL);
		RootPage rootBM = new RootPageBM(rootURL,xmlBM);
		
		String xmlBUT = driverBUT.load(rootURL);
		RootPage rootBUT = new RootPageBUT(rootURL,xmlBUT);
		*/
		
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
			e.printStackTrace();
		}
		
		IDelta delta = new DeltaSimple(rootBM, rootBUT);
		delta.computeDelta(rootBM, rootBUT);
		
		// il primo step non contiene alcun Elemento
		NavigationStep step = new NavigationStep(delta);
		
		Report report = Report.getInstance();
		report.addStep(step);
		
		ReloadManager reloadManager= new ReloadManager(driverBM, driverBUT);
		PlanManager planManager = new PlanManager();
		SurfManager surfManager = new SurfManager(driverBM,driverBUT);
		ComputeManager computeManager = new ComputeManager();
		
		// Crawler Cycle
		for(int i=0;i<nStep;i++){
			
			reloadManager.reload(rootURL,rootBM,rootBUT);
			
			Element element = planManager.plan(rootBM);
			
			List<TriggerResult> results = surfManager.surf(element);

			computeManager.compute(element, results);
			
		}
		
		
		
	}
	
	
	
	
}
