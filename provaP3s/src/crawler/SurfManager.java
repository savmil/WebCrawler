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
	
		/*
		// da mandare in parallelo: attenzione a come avviene poi la add!
		TriggerResult resultBM = bm_driver.trigger(element);	
		TriggerResult resultBUT = but_driver.trigger(element);
		
		surfResult.add(resultBM);
		surfResult.add(resultBUT);
		
		return surfResult;
		*/
		
		Thread t_bm=new surfManagerThread(surfResult,bm_driver,element);
		Thread t_but=new surfManagerThread(surfResult,but_driver,element);
		
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
