package crawler.entity;

import java.util.ArrayList;

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
	
}
