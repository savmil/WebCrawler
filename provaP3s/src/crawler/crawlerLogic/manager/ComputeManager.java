package crawler.crawlerLogic.manager;


import crawler.facilities.driver.TriggerResult;
import crawler.crawlerLogic.entity.*;
import crawler.crawlerLogic.entity.delta.*;
import crawler.crawlerLogic.entity.pages.*;
import java.util.Hashtable;

public class ComputeManager {
	private int id=0;
	private IDelta delta=null;
	public void compute(RootPage rootBM,RootPage rootBUT)// per noi va bene perchè sicuramente le abbiamo queste due pagine
	{
		delta = new DeltaSimple(rootBM, rootBUT);
		delta.computeDelta(rootBM, rootBUT);
		NavigationStep step = new NavigationStep(delta);
		Report report = Report.getInstance();
		report.addStep(step);
		rootBM.saveVisitedPage("BM");
		rootBUT.saveVisitedPage("BUT");
		System.out.println("[ComputeManager]: Passo di navigazione creato: URL= " + rootBM.getUrl());
		System.out.println("											   Delta= " + step.getDelta().getDelta());
		System.out.println("[ComputeManager]: Aggiunto il passo iniziale al report");
		
	}
	
	public void compute(Element element,Hashtable<String,TriggerResult> surfResult){
		
		
		String resultBM = surfResult.get("[SurfManagerThreadChrome]").getResult();
		boolean isErrorBM = surfResult.get("[SurfManagerThreadChrome]").getIsError();
		String xpathBM=surfResult.get("[SurfManagerThreadChrome]").getXpath();
		String resultBUT = surfResult.get("[SurfManagerThreadFirefox]").getResult();
		boolean isErrorBUT = surfResult.get("[SurfManagerThreadFirefox]").getIsError();
		String xpathBUT=surfResult.get("[SurfManagerThreadFirefox]").getXpath();
		
		element.setXPath(xpathBM);
		
		NavigationStep step = new NavigationStep(element);


		if(!isErrorBM && !isErrorBUT){
			VisitedPage PageBM = new VisitedPage(xpathBM,resultBM,id);
			VisitedPage PageBUT = new VisitedPage(xpathBUT,resultBUT,id);
			IDelta delta = new DeltaSimple(PageBM, PageBUT);
			delta.computeDelta(PageBM, PageBUT);
			step.setDelta(delta);	//settando delta associo anche le pagine al passo
			PageBM.saveVisitedPage("BM", id);
			PageBUT.saveVisitedPage("BUT", id);
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + step.getEvent().getXPath());
			System.out.println("	Delta -> " + step.getDelta().getDelta());
		}
		
		if(isErrorBM && isErrorBUT){
			ErrorP errorBM = new ErrorP(resultBM,id);
			ErrorP errorBUT = new ErrorP(resultBUT,id);
			
			step.setErrorBM(errorBM);
			step.setErrorBUT(errorBUT);
			errorBM.saveErrorP("BM",id);
			errorBUT.saveErrorP("BUT",id);
			
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + step.getEvent().getXPath());
			System.out.println("	Sono stati salvati i due errori");
		}
		
		if(isErrorBM && !isErrorBUT){
			ErrorP errorBM = new ErrorP(resultBM,id);
			
			VisitedPage PageBUT = new VisitedPage(xpathBUT,resultBUT,id);

			step.setErrorBM(errorBM);
			step.setRightPage(PageBUT);
			element.setXPath(xpathBUT);
			
			errorBM.saveErrorP("BM",id);
			PageBUT.saveVisitedPage("BUT", id);
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " +  step.getEvent().getXPath());
			System.out.println("	è stato salvato l'errore di Chrome");
		}
		
		if(!isErrorBM && isErrorBUT){
			ErrorP errorBUT = new ErrorP(resultBUT,id);
			
			VisitedPage PageBM = new VisitedPage(xpathBM,resultBM,id);

			step.setErrorBUT(errorBUT);
			step.setRightPage(PageBM);	
			element.setXPath(xpathBM);
			errorBUT.saveErrorP("BUT", id);
			PageBM.saveVisitedPage("BM", id);
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	è stato salvato l'errore di Firefox");
		}
		
		Report report = Report.getInstance();
		report.addStep(step);
		id++;
	}
}
