package crawler;

public interface BrowserDriver {
	
	public String load(String url);
	public VisitedPage trigger(Element element);
}
