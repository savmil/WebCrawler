package test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import crawler.crawlerLogic.entity.Element;
import crawler.crawlerLogic.entity.pages.RootPage;
import crawler.crawlerLogic.manager.PlanManager;
import crawler.crawlerLogic.manager.ReloadManager;
import crawler.crawlerLogic.manager.SurfManager;
import crawler.facilities.driver.BrowserDriver;
import crawler.facilities.driver.BrowserDriverChrome;
import crawler.facilities.driver.BrowserDriverFirefox;
import crawler.facilities.driver.TriggerResult;

public class SurfManagerTest {
	BrowserDriver benchmark;
	BrowserDriver under_test;
	Element element;
	@Before
	public void initilialize()
	{
		benchmark=new BrowserDriverChrome();
		under_test=new BrowserDriverFirefox();
		ReloadManager reloadManager=new ReloadManager(benchmark, under_test);
		/*RootPageBM rootBM=new RootPageBM("http://tinytuba.com/");
		RootPageBUT rootBUT=new RootPageBUT("http://tinytuba.com/");*/
		RootPage rootBM=new RootPage("http://tinytuba.com/");
		RootPage rootBUT=new RootPage("http://tinytuba.com/");
		reloadManager.reload(rootBM,rootBUT);
		PlanManager planManager=new PlanManager();
		element=planManager.plan(rootBM);
	}
	@Test
	public void testSurfwithNoAnchorAndButton() {
		SurfManager surfManager=new SurfManager(benchmark, under_test);
		Hashtable<String, TriggerResult> surfResult =surfManager.surf(element);
		//String resultBM = surfResult.get("[SurfManagerThreadChrome]").getResult();
		boolean isErrorBM = surfResult.get("[SurfManagerThreadChrome]").getIsError();
		String xpathBM=surfResult.get("[SurfManagerThreadChrome]").getXpath();
		//String resultBUT = surfResult.get("[SurfManagerThreadFirefox]").getResult();
		boolean isErrorBUT = surfResult.get("[SurfManagerThreadFirefox]").getIsError();
		String xpathBUT=surfResult.get("[SurfManagerThreadFirefox]").getXpath();
		assertEquals(true, isErrorBM);
		assertEquals(true, isErrorBUT);
		assertEquals(xpathBM, null);
		assertEquals(xpathBUT, null);
	}

}
