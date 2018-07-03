package crawler;

import java.util.ArrayList;
import java.util.List;

public class SurfManager 
{
	private BrowserDriver bm_driver;
	private BrowserDriver but_driver;
	
	public SurfManager(BrowserDriver benchmark, BrowserDriver under_test){
		bm_driver = benchmark;
		but_driver = under_test;
	}
	
	public List<TriggerResult> surf(Element element){
		
		List<TriggerResult> surfResult = new ArrayList<TriggerResult>();
		
		Thread t_bm=new SurfManagerThread(surfResult,bm_driver,element);
		t_bm.setName("[SurfManagerThreadChrome]");
		Thread t_but=new SurfManagerThread(surfResult,but_driver,element);
		t_but.setName("[SurfManagerThreadFirefox]");
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
