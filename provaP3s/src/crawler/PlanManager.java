package crawler;

import java.util.List;

public class PlanManager 
{
	Element Elementlist;
	RootPageBM rootBM;
	public PlanManager(RootPageBM rBM)
	{
		rootBM=rBM;
	}
	public Element selectElement(List<Element> ElementList)
	{
		
		Element randomElements=new Element();
		
		if (ElementList.size()!=0)
       	{
       			int randElement=(int)(Math.random()*ElementList.size());
       			randomElements=ElementList.get(randElement);
        }
		
		return randomElements;
	}
	public Element plan (RootPageBM rootBM)
	{
		List<Element> pageElements;
		pageElements=rootBM.getElements();
		Element selectedElement=selectElement(pageElements);
		return selectedElement;
	}
	
}
