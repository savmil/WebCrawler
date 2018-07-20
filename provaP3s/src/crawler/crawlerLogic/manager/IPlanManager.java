package crawler.crawlerLogic.manager;

import crawler.crawlerLogic.entity.Element;
import crawler.crawlerLogic.entity.pages.RootPage;

//pattern strategy
public interface IPlanManager {
	public Element plan(RootPage page);
}
