package crawler.UI;

import crawler.crawlerLogic.manager.CrawlerManager;

public class UIUserCL implements UIUser {


	@Override
	public void startTest(String rootURL, int nStep) {
		CrawlerManager crawler=CrawlerManager.getInstance();
		crawler.startTest(rootURL, nStep);

	}

}
