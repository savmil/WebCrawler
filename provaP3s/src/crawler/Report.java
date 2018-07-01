package crawler;

import java.util.ArrayList;

public class Report {
	
	private static ArrayList<NavigationStep> steps;
	
	public void addStep(NavigationStep step){
		steps.add(step);
	}
	
	//	pattern singleton
	// ********************
	private static Report instance;
	
	private Report(){}
	
	protected static Report getInstance(){
		if (instance==null){
			steps = new ArrayList<NavigationStep>();
			instance = new Report();
		}
		return instance;
	}
	// ********************
	
}
