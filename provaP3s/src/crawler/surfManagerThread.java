package crawler;

import java.util.List;

public class surfManagerThread extends Thread{
	
	private List<TriggerResult> lis;
	private BrowserDriver driver;
	private Element element;
	
	public surfManagerThread(List<TriggerResult> surfRes,BrowserDriver bro,Element element){
		lis=surfRes;
		driver=bro;
		this.element=element;
		this.start();
	}
	
	public void run(){
		
		TriggerResult surfresult =driver.trigger(element);
		
		synchronized(lis){
			lis.add(surfresult);
		}
	}
	
}
