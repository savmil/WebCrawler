package crawler.crawlerLogic.manager;

import crawler.crawlerLogic.entity.Element;
import crawler.facilities.converter.XmlConverter;
import crawler.facilities.driver.BrowserDriver;
import crawler.facilities.driver.TriggerResult;

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
		
		//String XMLerror=converter.string2xml(surfresult.getResult());
		String XML=converter.string2xml(surfresult.getResult());

		surfresult.setResult(XML);
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
