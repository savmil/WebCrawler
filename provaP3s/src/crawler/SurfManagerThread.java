package crawler;

import java.util.List;

public class SurfManagerThread extends Thread{
	
	private List<TriggerResult> lis;
	private BrowserDriver driver;
	private Element element;
	
	public SurfManagerThread(List<TriggerResult> surfRes,BrowserDriver bro,Element element){
		lis=surfRes;
		driver=bro;
		this.element=element;
		this.start();
	}
	
	public void run(){
		
		TriggerResult surfresult = driver.trigger(element);	
		System.out.println(this.getName() + ": Elemento triggerato sul browser");
		synchronized(lis){
			lis.add(surfresult);
		}
	}
	
}
