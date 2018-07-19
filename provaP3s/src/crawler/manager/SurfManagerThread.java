package crawler.manager;

import crawler.converter.XmlConverter;
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
		//System.out.println("Trigger"+surfresult.getXpath());
		XmlConverter converter =new XmlConverter();
		String XMLerror=converter.string2xml(surfresult.getResult());
		surfresult.setResult(XMLerror);
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
