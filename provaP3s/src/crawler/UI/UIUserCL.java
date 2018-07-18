package crawler.UI;

import crawler.manager.CrawlerManager;

public class UIUserCL implements UIUser {


	@Override
	public void startTest(String rootURL, int nStep) {
		CrawlerManager crawler=CrawlerManager.getInstance();
		crawler.startTest(rootURL, nStep);

	}

}
