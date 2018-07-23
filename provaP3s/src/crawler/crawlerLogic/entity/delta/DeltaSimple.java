package crawler.crawlerLogic.entity.delta;

import crawler.crawlerLogic.entity.pages.VisitedPage;

public class DeltaSimple extends IDelta{

	public DeltaSimple(VisitedPage p1, VisitedPage p2, double delta) {
		super(p1, p2,delta);
	}
	
	public DeltaSimple(VisitedPage p1, VisitedPage p2) {
		super(p1, p2);
	}

	@Override
	public void computeDelta(VisitedPage p1, VisitedPage p2) {
		double delta = p1.getXmlDescr().compareTo(p2.getXmlDescr());
		this.setDelta(Math.abs(delta));	
	}

}
