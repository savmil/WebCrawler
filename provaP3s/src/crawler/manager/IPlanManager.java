package crawler.manager;

import crawler.entity.Element;
import crawler.entity.pages.RootPage;

//pattern strategy
public interface IPlanManager {
	public Element plan(RootPage page);
}
