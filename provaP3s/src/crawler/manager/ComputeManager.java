package crawler.manager;


import crawler.entity.pages.*;
import crawler.entity.delta.*;
import crawler.driver.TriggerResult;
import crawler.entity.*;

import java.util.Hashtable;

public class ComputeManager {
	public NavigationStep computeR(RootPage rootBM,RootPage rootBUT)// per noi va bene perchè sicuramente le abbiamo queste due pagine
	{
		IDelta delta = new DeltaSimple(rootBM, rootBUT);
		delta.computeDelta(rootBM, rootBUT);
		NavigationStep step = new NavigationStep(delta);
		return step;
	}
	public void compute(Element element,Hashtable<String,TriggerResult> surfResult){
		
		NavigationStep step = new NavigationStep(element);
		
		// recupero parametri
		/*
		String resultBM = surfResult.get(0).getResult();
		boolean isErrorBM = surfResult.get(0).getIsError();
		String resultBUT = surfResult.get(1).getResult();
		boolean isErrorBUT = surfResult.get(1).getIsError();
		*/
		String resultBM = surfResult.get("[SurfManagerThreadChrome]").getResult();
		boolean isErrorBM = surfResult.get("[SurfManagerThreadChrome]").getIsError();
		String xpathBM=surfResult.get("[SurfManagerThreadChrome]").getXpath();
		String resultBUT = surfResult.get("[SurfManagerThreadFirefox]").getResult();
		boolean isErrorBUT = surfResult.get("[SurfManagerThreadFirefox]").getIsError();
		String xpathBUT=surfResult.get("[SurfManagerThreadFirefox]").getXpath();
		//System.out.println("errore 1 \r"+resultBM);
		//System.out.println("errore 2 \r"+resultBUT);
		if(!isErrorBM && !isErrorBUT){
			VisitedPage PageBM = new VisitedPageBM(xpathBM,resultBM);
			VisitedPage PageBUT = new VisitedPageBUT(xpathBUT,resultBUT);
			IDelta delta = new DeltaSimple(PageBM, PageBUT);
			delta.computeDelta(PageBM, PageBUT);
			
			step.setDelta(delta);	//settando delta associo anche le pagine al passo
			element.setXPath(xpathBM);
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	Delta -> " + step.getDelta().getDelta());
		}
		
		if(isErrorBM && isErrorBUT){
			ErrorP errorBM = new ErrorP(resultBM);
			ErrorP errorBUT = new ErrorP(resultBUT);
			
			step.setErrorBM(errorBM);
			step.setErrorBUT(errorBUT);
			
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			//System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	Sono stati salvati i due errori");
		}
		
		if(isErrorBM && !isErrorBUT){
			ErrorP errorBM = new ErrorP(resultBM);
			VisitedPage PageBUT = new VisitedPageBUT(xpathBUT,resultBUT);
			
			step.setErrorBM(errorBM);
			step.setRightPage(PageBUT);
			element.setXPath(xpathBUT);
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	è stato salvato l'errore di Chrome");
		}
		
		if(!isErrorBM && isErrorBUT){
			ErrorP errorBUT = new ErrorP(resultBUT);
			VisitedPage PageBM = new VisitedPageBM(xpathBM,resultBM);
			
			step.setErrorBUT(errorBUT);
			step.setRightPage(PageBM);	
			element.setXPath(xpathBM);
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	è stato salvato l'errore di Firefox");
		}
		
		Report report = Report.getInstance();
		report.addStep(step);
		
	}
}
