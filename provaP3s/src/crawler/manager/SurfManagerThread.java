package crawler.manager;

import java.util.List;
import crawler.driver.BrowserDriver;
import crawler.driver.TriggerResult;
import crawler.entity.Element;


import java.util.Hashtable;

public class SurfManagerThread extends Thread{
	
	private Hashtable<String, TriggerResult> hs;
	private BrowserDriver driver;
	private Element element;
	
	public SurfManagerThread(Hashtable<String, TriggerResult> surfRes,BrowserDriver bro,Element element){
		hs=surfRes;
		driver=bro;
		this.element=element;
		this.start();
	}
	
	public void run(){
		
		TriggerResult surfresult = driver.trigger(element);
		if(!surfresult.getIsError())
		{
			System.out.println(this.getName() + ": Elemento triggerato sul browser");
		}
		hs.put(this.getName(), surfresult);
		/*synchronized(lis){
			lis.add(surfresult);
		}*/
	}
	
}
