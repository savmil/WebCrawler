package crawler;

public class SurfManager 
{
	BrowserDriver benchmark_browser_driver;
	BrowserDriver browser_under_test_browser_driver;
	public SurfManager(BrowserDriver benchmark, BrowserDriver under_test)//sono i browser che istanzia il crawler
	{
		benchmark_browser_driver=benchmark;
		browser_under_test_browser_driver=under_test;
	}
	Element element;
	public SurfManager(Element e)
	{
		element=e;
	}
	
	public void surf(Element element) 
	{
		try
		{
			benchmark_browser_driver.trigger(element);
		}
		catch(Throwable e)
		{
			// l' ho messa per catturare qualsiasi errore dato che quel is error non mi viene come farlo restituire		
		}
		
		try
		{
			benchmark_browser_driver.trigger(element);
		}
		catch(Throwable e)
		{
			// l' ho messa per catturare qualsiasi errore dato che quel is error non mi viene come farlo restituire		
		}
	}
}
