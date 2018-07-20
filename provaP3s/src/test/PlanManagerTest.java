package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import crawler.crawlerLogic.entity.Element;
import crawler.crawlerLogic.entity.pages.RootPageBM;
import crawler.crawlerLogic.manager.PlanManager;

public class PlanManagerTest {
	@Test
	public void testPlanNoElement() 
	{
		PlanManager plan =new PlanManager();
		RootPageBM root= new RootPageBM("test");
		Element element =plan.plan(root);
		assertNull(element.getXPath());
	}
	@Test
	public void testPlanWithElement()
	{
		PlanManager plan =new PlanManager();
		RootPageBM root= new RootPageBM("test");
		ArrayList<Element> elements=new ArrayList<Element>();
		root.setElements(elements);
		Element e=new Element();
		e.setXPath("test");
		elements.add(e);
		root.setElements(elements);
		Element element=plan.plan(root);
		assertEquals("test", element.getXPath());
	}

}
