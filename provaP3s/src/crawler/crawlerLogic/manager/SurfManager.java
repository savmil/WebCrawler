package crawler.crawlerLogic.manager;

import crawler.crawlerLogic.entity.Element;
import crawler.facilities.driver.*;

import java.util.Hashtable;

public class SurfManager 
{
	private BrowserDriver bm_driver;
	private BrowserDriver but_driver;
	
	public SurfManager(BrowserDriver benchmark, BrowserDriver under_test){
		bm_driver = benchmark;
		but_driver = under_test;
	}
	
	public Hashtable<String,TriggerResult> surf(Element element){
		
		
		Hashtable<String, TriggerResult> surfResult=new Hashtable<>();

		Thread t_bm=new SurfManagerThread(surfResult,bm_driver,element);
		t_bm.setName("[SurfManagerThreadChrome]");
		
	
		Thread t_but=new SurfManagerThread(surfResult,but_driver,element);
		t_but.setName("[SurfManagerThreadFirefox]");
		
		try {
			t_bm.join();
			t_but.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return surfResult;
	}
}
