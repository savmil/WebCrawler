package crawler;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReloadManager 
{
	private RemoteWebDriver driverBUT;
	private RemoteWebDriver driverBM;
	private RootPageBM RootBM;
	private RootPageBUT RootBUT;
	private String rootURL;
	
	public ReloadManager(String rootURL,RootPageBM RBM,RootPageBUT RBUT) {
		driverBUT = new FirefoxDriver();
		driverBM = new ChromeDriver();
		RootBM = RBM;
		RootBUT = RBUT;
		this.rootURL=rootURL;
	}
	
	void /*XML*/ load(/*Qui non credo serva il parametro URL*/){
		
		driverBUT.get(rootURL);
		
		RootBUT.updateXML(/*XML*/);
		RootBUT.loadElements();
		
		//Par ---
		
		driverBM.get(rootURL);
		RootBM.updateXML(/*XML*/);
		RootBM.loadElements();
	}
}
