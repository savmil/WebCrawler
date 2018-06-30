package crawler;

import javax.xml.crypto.dsig.XMLObject;

public class ReloadThread extends Thread{
	
	private String url;
	private RootPage rootP;
	
	public ReloadThread(String url,RootPage r){
		this.url = url;
		rootP = r;
	}
	
	public void run(){
		BrowserDriver driverBM = new BrowserDriverBenchmark();
		XMLObject xmlBM = driverBM.load(url);
		rootP.setXmlDescr(xmlBM);
		rootP.loadElements();
	}
}
