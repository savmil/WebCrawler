package crawler;

import java.util.List;

public class PlanManager implements IPlanManager{
	
	public Element selectElement(List<Element> elementList){
		
		Element randomElements = new Element();
		if (elementList.size()!=0){
       			int randElement=(int)(Math.random()*elementList.size());
       			randomElements=elementList.get(randElement);
        }
		
		return randomElements;
	}
	
	//pattern strategy
	@Override
	public Element plan (RootPage rootBM){
		
		List<Element> pageElements = rootBM.getElements();
		Element selectedElement=selectElement(pageElements);
		
		return selectedElement;
	}
	
	
	
	
}
