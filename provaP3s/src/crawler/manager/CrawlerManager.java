package crawler.manager;

import java.util.List;

import crawler.entity.delta.*;
import crawler.driver.*;
import crawler.entity.pages.*;
import crawler.entity.*;

import java.util.Hashtable;

public class CrawlerManager 
{
	/***singleton***/
	private static CrawlerManager instance;
	
	private CrawlerManager(){}
	
	public static CrawlerManager getInstance(){
		if (instance==null){
			instance=new CrawlerManager();
		}
		return instance; 
	}
	/****/
	public void startTest(String rootURL,int nStep){
		
		BrowserDriver driverBM =  new BrowserDriverChrome();
		BrowserDriver driverBUT = new BrowserDriverFirefox();
		System.out.println("[CrawlerManager]: DriverChrome e DriverFirefox instanziati");
		
		/* Codice sequenziale
		String xmlBM = driverBM.load(rootURL);
		RootPage rootBM = new RootPageBM(rootURL,xmlBM);
		
		String xmlBUT = driverBUT.load(rootURL);
		RootPage rootBUT = new RootPageBUT(rootURL,xmlBUT);
		*/
		
		RootPage rootBM = new RootPageBM(rootURL);
		RootPage rootBUT = new RootPageBUT(rootURL);
		
		Thread workerBM = new ReloadThread(rootBM,driverBM);
		workerBM.setName("[LoadManagerThreadChrome]");
		Thread workerBUT = new ReloadThread(rootBUT,driverBUT);
		workerBUT.setName("[LoadManagerThreadFirefox]");
		
		workerBM.start();
		workerBUT.start();
		
		try {
			workerBM.join();
			workerBUT.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[CrawlerManager]: Pagina root scaricata dai browser");
		
		IDelta delta = new DeltaSimple(rootBM, rootBUT);
		delta.computeDelta(rootBM, rootBUT);
		
		// il primo step non contiene alcun Elemento
		NavigationStep step = new NavigationStep(delta);
		System.out.println("[CrawlerManager]: Passo di navigazione creato: URL= " + rootURL);
		System.out.println("											   Delta= " + delta.getDelta());
		
		Report report = Report.getInstance();
		report.addStep(step);
		System.out.println("[CrawlerManager]: Aggiunto il passo iniziale al report");
		
		ReloadManager reloadManager= new ReloadManager(driverBM, driverBUT);
		//IPlanManager planManager = new PlanManager();
		PlanManager planManager = new PlanManager();
		SurfManager surfManager = new SurfManager(driverBM,driverBUT);
		ComputeManager computeManager = new ComputeManager();
		
		// Crawler Cycle
		System.out.println("[CrawlerManager]: Entro in Crawler Cycle");
		for(int i=0;i<nStep;i++){
			reloadManager.reload(rootURL,rootBM,rootBUT);
			
			Element element = planManager.plan(rootBM);
			
			Hashtable<String, TriggerResult> results = surfManager.surf(element);

			computeManager.compute(element, results);
		}
		
		driverBM.closeDriver();
		driverBUT.closeDriver();
		
	}	
}