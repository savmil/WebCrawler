package crawler.crawlerLogic.manager;

import crawler.crawlerLogic.entity.*;
import crawler.crawlerLogic.entity.pages.*;
import crawler.facilities.driver.*;

import java.io.File;
import java.util.Hashtable;

public class CrawlerManager 
{
	private IPlanManager planManager;
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
	public void startTest(String rootURL,int nStep)
	{
		
		BrowserDriver driverBM =  new BrowserDriverChrome();
		BrowserDriver driverBUT = new BrowserDriverFirefox();
		System.out.println("[CrawlerManager]: DriverChrome e DriverFirefox instanziati");
		
		File filebut = new File("BUT");
        if (!filebut.exists()) 
        {
            filebut.mkdir();
        }
        else
        {
        	String[]entries = filebut.list();
        	for(String s: entries)
        	{
        	    File currentFile = new File(filebut.getPath(),s);
        	    currentFile.delete();
        	}
        }
        File filebm = new File("BM");
        if (!filebm.exists()) 
        {
        	
            filebm.mkdir();
        }
        else
        {
        	String[]entries = filebm.list();
        	for(String s: entries)
        	{
        	    File currentFile = new File(filebm.getPath(),s);
        	    currentFile.delete();
        	}
        }
        File reportfile= new File("report.xml");
        if (reportfile.exists())
        {
        	reportfile.delete();
        }

        RootPage rootBM = new RootPage(rootURL);
        RootPage rootBUT = new RootPage(rootURL);
		ReloadManager reloadManager= new ReloadManager(driverBM, driverBUT);
		reloadManager.reload(rootBM,rootBUT);
		ComputeManager computeManager = new ComputeManager();
		
		System.out.println("[CrawlerManager]: Pagina root scaricata dai browser");
		computeManager.compute(rootBM, rootBUT);
		
		
		planManager = new PlanManager();
		SurfManager surfManager = new SurfManager(driverBM,driverBUT);
		
		
		// Crawler Cycle
		System.out.println("[CrawlerManager]: Entro in Crawler Cycle");
		for(int i=0;i<nStep;i++){
			reloadManager.reload(rootBM,rootBUT);
			
			Element element = planManager.plan(rootBM);
			
			Hashtable<String, TriggerResult> results = surfManager.surf(element);

			computeManager.compute(element, results);
		}
		
		Report report =Report.getInstance();
		report.saveReport();
		
		driverBM.closeDriver();
		driverBUT.closeDriver();
	
	}	
	
}
