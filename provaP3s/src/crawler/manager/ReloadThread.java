package crawler.manager;

import crawler.driver.BrowserDriver;
import crawler.driver.HtmlData;
import crawler.entity.pages.RootPage;
import crawler.converter.XmlConverter;
public class ReloadThread extends Thread{
	
	private RootPage rootP;
	private BrowserDriver driver;
	private XmlConverter xmlconverter;
	public ReloadThread(RootPage rootP, BrowserDriver driver) {
		super();
		this.rootP = rootP;
		this.driver = driver;
		xmlconverter=new XmlConverter();
	}

	public void run(){
		System.out.println(this.getName() + ": Avvio la ricarica della pagina.");
		HtmlData htmlData = driver.load(rootP.getUrl());
		System.out.println(this.getName() + ": Pagina ricaricata con successo.");
		String xml=xmlconverter.html2xml(htmlData.getHtml());
		rootP.setXmlDescr(xml);
		System.out.println(this.getName() + ": Avvio la ricarica degli elementi.");
		rootP.setElements(htmlData.getElementList());
		System.out.println(this.getName() + ": Elementi ricaricati con successo.");
	}
}
