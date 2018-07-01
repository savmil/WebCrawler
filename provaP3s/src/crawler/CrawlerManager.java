package crawler;

import java.util.List;

public class CrawlerManager 
{

	void startTest(String rootURL,int nStep){
		
		BrowserDriver driverBM = new BrowserDriverBenchmark();
		BrowserDriver driverBUT = new BrowserDriverUnderTest();
		
		// in parallelo
		String xmlBM = driverBM.load(rootURL);
		RootPage rootBM = new RootPageBM(rootURL,xmlBM);
		
		String xmlBUT = driverBUT.load(rootURL);
		RootPage rootBUT = new RootPageBUT(rootURL,xmlBUT);
		
		//join e recupero dei risultati del thread
		
		IDelta delta = new DeltaSimple(rootBM, rootBUT);
		delta.computeDelta(rootBM, rootBUT);
		
		// il primo step non contiene alcun Elemento
		NavigationStep step = new NavigationStep(delta);
		
		Report report = Report.getInstance();
		report.addStep(step);
		
		for(int i=0;i<nStep;i++){
			ReloadManager reloadManager= new ReloadManager(driverBM, driverBUT);
			reloadManager.reload(rootURL,rootBM,rootBUT);
			
			PlanManager planManager = new PlanManager();
			Element element = planManager.plan(rootBM);
			
			SurfManager surfManager = new SurfManager(driverBM,driverBUT);
			List<TriggerResult> results = surfManager.surf(element);

			ComputeManager computeManager = new ComputeManager();
			computeManager.compute(element, results);
			
		}
	}
	
	
	
	
}
