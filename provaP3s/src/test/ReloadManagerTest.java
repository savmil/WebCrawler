package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import crawler.crawlerLogic.entity.pages.RootPageBM;
import crawler.crawlerLogic.entity.pages.RootPageBUT;
import crawler.crawlerLogic.manager.ReloadManager;
import crawler.facilities.driver.BrowserDriver;
import crawler.facilities.driver.BrowserDriverChrome;
import crawler.facilities.driver.BrowserDriverFirefox;

public class ReloadManagerTest {

	@Test
	public void testReloadCorrectPage() {
		BrowserDriver driverBM=new BrowserDriverChrome();
		BrowserDriver driverBUT=new BrowserDriverFirefox();
		ReloadManager reloadManager =new ReloadManager(driverBM,driverBUT);
		RootPageBM rootBM=new RootPageBM("http://www.docenti.unina.it");
		RootPageBUT rootBUT=new RootPageBUT("http://www.docenti.unina.it");
		try
		{
			reloadManager.reload(rootBM, rootBUT);
		}
		catch (Throwable e) {
			fail(" la pagina doveva essere aperta");
		}
		driverBM.closeDriver();
		driverBUT.closeDriver();
		
	}

	@Test
	public void testReloadIncorrectPage() {
		BrowserDriver driverBM=new BrowserDriverChrome();
		BrowserDriver driverBUT=new BrowserDriverFirefox();
		ReloadManager reloadManager =new ReloadManager(driverBM,driverBUT);
		RootPageBM rootBM=new RootPageBM("http://");
		RootPageBUT rootBUT=new RootPageBUT("http://");
		try
		{
			reloadManager.reload(rootBM, rootBUT);
			
		}
		catch (Throwable e) {
			
		}
		fail(" la pagina non doveva essere aperta");
		driverBM.closeDriver();
		driverBUT.closeDriver();
	}

}
