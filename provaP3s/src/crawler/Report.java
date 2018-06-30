package crawler;

import java.util.ArrayList;

public class Report {
	
	private ArrayList<NavigationStep> steps;
	
	public void addStep(NavigationStep step){
		steps.add(step);
	}
	
	//	pattern singleton
	// ********************
	private Report instance;
	
	private Report(){}
	
	protected Report getInstance(){
		if (instance==null){
			steps = new ArrayList<NavigationStep>();
			instance = new Report();
		}
		return instance;
	}
	// ********************
	
}
