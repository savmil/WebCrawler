package crawler;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReloadManager 
{
	private BrowserDriverUnderTest driverBUT;
	private BrowserDriverBenchmark driverBM;
	private RootPageBM RootBM;
	private RootPageBUT RootBUT;
	private String rootURL;
	
	public ReloadManager(String rootURL,RootPageBM RBM,RootPageBUT RBUT) {

		RootBM = RBM;
		RootBUT = RBUT;
		this.rootURL=rootURL;
	}
	
	void Reload(){
		driverBM=new BrowserDriverBenchmark();
		driverBUT.load(rootURL);
		
		RootBUT.updateXML(/*XML*/);
		RootBUT.loadElements();
		
		//Par ---
		
		driverBUT=new BrowserDriverUnderTest();
		driverBUT.load(rootURL);
		RootBM.updateXML(/*XML*/);
		RootBM.loadElements();
	}
}
