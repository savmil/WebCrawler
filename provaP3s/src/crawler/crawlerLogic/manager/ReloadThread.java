package crawler.crawlerLogic.manager;

import crawler.facilities.converter.XmlConverter;
import crawler.facilities.driver.BrowserDriver;
import crawler.facilities.driver.HtmlData;
import crawler.crawlerLogic.entity.pages.RootPage;
public class ReloadThread extends Thread{
	
	private RootPage rootP;
	private BrowserDriver driver;
	private XmlConverter converter;
	public ReloadThread(RootPage rootP, BrowserDriver driver) {
		super();
		this.rootP = rootP;
		this.driver = driver;
		converter=new XmlConverter();
	}

	public void run(){
		System.out.println(this.getName() + ": Avvio la ricarica della pagina.");
		HtmlData htmlData = driver.load(rootP.getUrl());
		System.out.println(this.getName() + ": Pagina ricaricata con successo.");
		String xml=converter.string2xml(htmlData.getHtml());
		rootP.setXmlDescr(xml);
		System.out.println(this.getName() + ": Avvio la ricarica degli elementi.");
		rootP.setElements(htmlData.getElementList());
		System.out.println(this.getName() + ": Elementi ricaricati con successo.");
	}
}
