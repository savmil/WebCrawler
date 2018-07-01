package crawler;

public abstract class BrowserAbstractFactory 
{
	public static BrowserAbstractFactory getFactory(String driver)
	{
		BrowserAbstractFactory but=null;
		if (driver.equals("BM"))
		{
			but= new ConcreteFatoryBM();
		}
		else if(driver.equals("BUT"))
		{
			but= new ConcreteFactoryBUT();
		}
		return but;
	}
	public abstract  BrowserDriver createDriver();

}
