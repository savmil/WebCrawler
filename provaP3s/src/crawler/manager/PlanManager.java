package crawler.manager;

import java.util.List;

import crawler.entity.pages.RootPage;
import crawler.entity.Element;

public class PlanManager implements IPlanManager{
	
	private Element selectElement(List<Element> elementList){
		
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
		
		System.out.println("[PlanManager]: SizeListaElementi = " + pageElements.size());
		return selectedElement;
	}	
}
