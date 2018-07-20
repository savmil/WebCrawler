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
		
		//List<TriggerResult> surfResult = new ArrayList<TriggerResult>();
		Hashtable<String, TriggerResult> surfResult=new Hashtable<>();

		Thread t_bm=new SurfManagerThread(surfResult,bm_driver,element);
		t_bm.setName("[SurfManagerThreadChrome]");
		//t_bm.setName("0");
	
		Thread t_but=new SurfManagerThread(surfResult,but_driver,element);
		t_but.setName("[SurfManagerThreadFirefox]");
		//t_but.setName("1");
		try {
			t_bm.join();
			t_but.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return surfResult;
	}
}
