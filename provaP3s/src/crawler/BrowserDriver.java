package crawler;

public interface BrowserDriver {
	
	public String load(String url);
	public TriggerResult trigger(Element element);
}
