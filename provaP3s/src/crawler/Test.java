package crawler;

public class Test implements UIUser {

	@Override
	public void startTest(String rootURL, int nStep) {
		CrawlerManager crawler=new CrawlerManager();
		crawler.startTest(rootURL, nStep);

	}

	@Override
	public void showReport() {
		// TODO Auto-generated method stub

	}
	public static void main(String args[]){
		
		Test test=new Test();
		test.startTest("http://www.repubblica.it", 3);
	}

}
