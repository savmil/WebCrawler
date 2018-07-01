package crawler;

public class ConcreteFactoryBUT extends BrowserAbstractFactory {
	public BrowserDriver createDriver()
	{
		return new BrowserDriverUnderTest();
	}
}
