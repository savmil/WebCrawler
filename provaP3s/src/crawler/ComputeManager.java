package crawler;

import java.util.List;

public class ComputeManager {
	
	public void compute(Element element,List<TriggerResult> surfResult){
		
		NavigationStep step = new NavigationStep(element);
		
		// recupero parametri
		String resultBM = surfResult.get(0).getResult();
		boolean isErrorBM = surfResult.get(0).getIsError();
		String resultBUT = surfResult.get(1).getResult();
		boolean isErrorBUT = surfResult.get(1).getIsError();
		
		if(!isErrorBM && !isErrorBUT){
			VisitedPage PageBM = new VisitedPageBM(element.getXPath(),resultBM);
			VisitedPage PageBUT = new VisitedPageBUT(element.getXPath(),resultBUT);
			
			IDelta delta = new DeltaSimple(PageBM, PageBUT);
			delta.computeDelta(PageBM, PageBUT);
			
			step.setDelta(delta);	//settando delta associo anche le pagine al passo
			
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
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	Sono stati salvati i due errori");
		}
		
		if(isErrorBM && !isErrorBUT){
			ErrorP errorBM = new ErrorP(resultBM);
			VisitedPage PageBUT = new VisitedPageBUT(element.getXPath(),resultBUT);
			
			step.setErrorBM(errorBM);
			step.setRightPage(PageBUT);
			
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	è stato salvato l'errore di Chrome");
		}
		
		if(!isErrorBM && isErrorBUT){
			ErrorP errorBUT = new ErrorP(resultBUT);
			VisitedPage PageBM = new VisitedPageBM(element.getXPath(),resultBM);
			
			step.setErrorBUT(errorBUT);
			step.setRightPage(PageBM);	
			
			System.out.println("[ComputeManager]: passo di navigazione creato -> ");
			System.out.println("	Elemento -> " + element.getXPath());
			System.out.println("	è stato salvato l'errore di Firefox");
		}
		
		Report report = Report.getInstance();
		report.addStep(step);
		
	}
}
