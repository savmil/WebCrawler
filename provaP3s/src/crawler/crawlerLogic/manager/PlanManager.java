package crawler.crawlerLogic.manager;

import java.util.List;

import crawler.crawlerLogic.entity.Element;
import crawler.crawlerLogic.entity.pages.RootPage;

public class PlanManager implements IPlanManager{
	
	private Element selectElement(List<Element> elementList){
		
		Element randomElements = new Element();
		if (elementList.size()!=0){
       			int randElement=(int)(Math.random()*(elementList.size()-1));
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
