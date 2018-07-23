package crawler.crawlerLogic.entity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import crawler.crawlerLogic.entity.delta.IDelta;

public class Report {
	
	private static ArrayList<NavigationStep> steps;
	
	public void addStep(NavigationStep step){
		steps.add(step);
	}
	public ArrayList<NavigationStep> getSteps()
	{
		return steps;
	}
	
	//	pattern singleton
	// ********************
	private static Report instance;
	
	private Report(){}
	
	public static Report getInstance(){
		if (instance==null){
			steps = new ArrayList<NavigationStep>();
			instance = new Report();
		}
		return instance;
	}
	// ********************
	public void saveReport(){
		Report report= Report.getInstance();
		try{
			PrintWriter reportf = new PrintWriter ("report.xml");
			
			for (int i=0;i<report.getSteps().size();i++){
				NavigationStep step=report.getSteps().get(i);
				IDelta delta=step.getDelta();
				if(delta!=null){
					if(i==0)
					{
						reportf.write("root");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("BM");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("rootBM.xml");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("BUT");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("rootBUT.xml");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("Delta");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write(Double.toString(delta.getDelta()));
						reportf.write('\r');
						reportf.write('\r');
					}
					else
					{
						reportf.write("step"+delta.getP1().getId());
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("Xpath");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write(step.getEvent().getXPath());					
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("BM");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write(delta.getP1().getId()+".xml");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("BUT");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write(delta.getP2().getId()+".xml");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write("Delta");
						reportf.write('\r');
						reportf.write('\r');
						reportf.write(Double.toString(delta.getDelta()));
						reportf.write('\r');
						reportf.write('\r');
					}
					
				}
				else if(step.getErrorBM()!=null && step.getErrorBUT()==null ){
					reportf.write("step"+step.getRightPage().getId());
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("erroreBM");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write(step.getErrorBM().getId()+".xml");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("BUT");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write(step.getRightPage().getId()+".xml");
					reportf.write('\r');
					reportf.write('\r');
				}
				else if(step.getErrorBUT()!=null && step.getErrorBM()==null){
					reportf.write("step"+step.getRightPage().getId());
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("erroreBUT");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write(step.getErrorBUT().getId()+".xml");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("BM");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write(step.getRightPage().getId()+".xml");
					reportf.write('\r');
					reportf.write('\r');
				}
				else if(step.getErrorBUT()!=null && step.getErrorBM()!=null){
					reportf.write("step"+step.getErrorBM().getId());
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("erroreBUT");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write(step.getErrorBUT().getId()+".xml");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write("erroreBM");
					reportf.write('\r');
					reportf.write('\r');
					reportf.write(step.getErrorBM().getId()+".xml");
					reportf.write('\r');
					reportf.write('\r');
				}	
			}
			reportf.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
