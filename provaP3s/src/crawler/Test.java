package crawler;

public class Test implements IUser {

	@Override
	public void startTest(String rootURL, int nStep) {
		CrawlerManager crawler=new CrawlerManager();
		crawler.startTest(rootURL, nStep);

	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub

	}
	public static void main(String args[])
	{
		
		Test test=new Test();
		test.startTest("http:\\www.docenti.unina.it", 1);
	}

}
