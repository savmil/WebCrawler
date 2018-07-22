package crawler.crawlerLogic.manager;

import crawler.crawlerLogic.entity.*;
import crawler.crawlerLogic.entity.delta.IDelta;
import crawler.crawlerLogic.entity.pages.*;
import crawler.facilities.driver.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		/* Codice sequenziale
		String xmlBM = driverBM.load(rootURL);
		RootPage rootBM = new RootPageBM(rootURL,xmlBM);
		
		String xmlBUT = driverBUT.load(rootURL);
		RootPage rootBUT = new RootPageBUT(rootURL,xmlBUT);
		*/
		
		/*RootPage rootBM = new RootPageBM(rootURL);
		RootPage rootBUT = new RootPageBUT(rootURL);*/
        RootPage rootBM = new RootPage(rootURL);
        RootPage rootBUT = new RootPage(rootURL);
		ReloadManager reloadManager= new ReloadManager(driverBM, driverBUT);
		//IPlanManager planManager = new PlanManager();
		reloadManager.reload(rootBM,rootBUT);
		ComputeManager computeManager = new ComputeManager();
		
		/*Thread workerBM = new ReloadThread(rootBM,driverBM);
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
		}*/
		
		System.out.println("[CrawlerManager]: Pagina root scaricata dai browser");
		computeManager.compute(rootBM, rootBUT);
		//IDelta delta = new DeltaSimple(rootBM, rootBUT);
		//delta.computeDelta(rootBM, rootBUT);
		// il primo step non contiene alcun Elemento
		
		
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
		
		try
		{
			Report report =Report.getInstance();
			PrintWriter reportf = new PrintWriter ("report.xml");
			for (int i=1;i<report.getSteps().size();i++)
			{
				NavigationStep step=report.getSteps().get(i);
				IDelta delta=step.getDelta();
				if(delta!=null)
				{
					reportf.write("step"+delta.getP1().getId());
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("Xpath");
					reportf.write('\r');
					reportf.write(step.getEvent().getXPath());
					reportf.write('\r');
					reportf.write("BM");
					reportf.write('\r');
					reportf.write(delta.getP1().getId()+".xml");
					reportf.write('\r');
					reportf.write("BUT");
					reportf.write('\r');
					reportf.write(delta.getP2().getId()+".xml");
					reportf.write('\r');
					reportf.write("Delta");
					reportf.write('\r');
					reportf.write(Double.toString(delta.getDelta()));
					reportf.write('\r');
					//reportf.write(delta.ge);
					//delta
				}
				else if(step.getErrorBM()!=null && step.getErrorBUT()==null )
				{
					reportf.write("step"+step.getRightPage().getId());
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("erroreBM");
					reportf.write('\r');
					reportf.write(step.getErrorBM().getId()+".xml");
					reportf.write('\r');
					reportf.write("BUT");
					reportf.write('\r');
					reportf.write(step.getRightPage().getId()+".xml");
					reportf.write('\r');
				}
				else if(step.getErrorBUT()!=null && step.getErrorBM()==null)
				{
					reportf.write("step"+step.getRightPage().getId());
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("erroreBUT");
					reportf.write('\r');
					reportf.write(step.getErrorBUT().getId()+".xml");
					reportf.write('\r');
					reportf.write("BM");
					reportf.write('\r');
					reportf.write(step.getRightPage().getId()+".xml");
					reportf.write('\r');
				}
				else if(step.getErrorBUT()!=null && step.getErrorBM()!=null)
				{
					reportf.write("step"+step.getErrorBM().getId());
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("erroreBUT");
					reportf.write('\r');
					reportf.write(step.getErrorBUT().getId()+".xml");
					reportf.write('\r');
					reportf.write("erroreBM");
					reportf.write('\r');
					reportf.write(step.getErrorBM().getId()+".xml");
					reportf.write('\r');
				}
				
			}
			reportf.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		driverBM.closeDriver();
		driverBUT.closeDriver();
		
	}	
}
