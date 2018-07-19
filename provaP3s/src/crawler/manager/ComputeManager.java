package crawler.manager;


import crawler.entity.pages.*;
import crawler.entity.delta.*;
import crawler.driver.TriggerResult;
import crawler.entity.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		try
		{
			PrintWriter but = new PrintWriter ("BUT\\root.xml");
			PrintWriter bm = new PrintWriter ("BM\\root.xml");
			but.write(rootBUT.getXmlDescr());
			bm.write(rootBM.getXmlDescr());
			but.close();
			bm.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
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
		
		//System.out.println("xpath \r \r \r"+xpathBM);
		NavigationStep step = new NavigationStep(element);
		PrintWriter but=null;
		PrintWriter bm=null;
		try
		{
			but = new PrintWriter ("BUT\\"+id+".xml");
			bm = new PrintWriter ("BM\\"+id+".xml");
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		// recupero parametri
		/*
		String resultBM = surfResult.get(0).getResult();
		boolean isErrorBM = surfResult.get(0).getIsError();
		String resultBUT = surfResult.get(1).getResult();
		boolean isErrorBUT = surfResult.get(1).getIsError();
		*/
		
		//System.out.println("errore 1 \r"+resultBM);
		//System.out.println("errore 2 \r"+resultBUT);
		
		if(!isErrorBM && !isErrorBUT){
			System.out.println(resultBM);
			
			VisitedPage PageBM = new VisitedPageBM(xpathBM,resultBM,id);
			VisitedPage PageBUT = new VisitedPageBUT(xpathBUT,resultBUT,id);
			IDelta delta = new DeltaSimple(PageBM, PageBUT);
			delta.computeDelta(PageBM, PageBUT);
			step.setDelta(delta);	//settando delta associo anche le pagine al passo
			but.write(resultBUT);
			bm.write(resultBM);
			but.close();
			bm.close();
			
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + step.getEvent().getXPath());
			System.out.println("	Delta -> " + step.getDelta().getDelta());
		}
		
		if(isErrorBM && isErrorBUT){
			ErrorP errorBM = new ErrorP(resultBM,id);
			ErrorP errorBUT = new ErrorP(resultBUT,id);
			
			step.setErrorBM(errorBM);
			step.setErrorBUT(errorBUT);
			but.write(errorBUT.getError());
			bm.write(errorBM.getError());
			but.close();
			bm.close();
			
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + step.getEvent().getXPath());
			System.out.println("	Sono stati salvati i due errori");
		}
		
		if(isErrorBM && !isErrorBUT){
			ErrorP errorBM = new ErrorP(resultBM,id);
			VisitedPage PageBUT = new VisitedPageBUT(xpathBUT,resultBUT,id);
			
			step.setErrorBM(errorBM);
			step.setRightPage(PageBUT);
			element.setXPath(xpathBUT);
			
			bm.write(errorBM.getError());
			bm.close();
			but.write(resultBUT);
			but.close();	
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			//System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	è stato salvato l'errore di Chrome");
		}
		
		if(!isErrorBM && isErrorBUT){
			ErrorP errorBUT = new ErrorP(resultBUT,id);
			VisitedPage PageBM = new VisitedPageBM(xpathBM,resultBM,id);
			
			step.setErrorBUT(errorBUT);
			step.setRightPage(PageBM);	
			element.setXPath(xpathBM);
			but.write(errorBUT.getError());
			bm.write(resultBM);
			but.close();
			bm.close();
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	è stato salvato l'errore di Firefox");
		}
		
		Report report = Report.getInstance();
		report.addStep(step);
		id++;
	}
}
