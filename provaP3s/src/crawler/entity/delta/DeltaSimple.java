package crawler.entity.delta;

import crawler.entity.pages.VisitedPage;

public class DeltaSimple extends IDelta{

	public DeltaSimple(VisitedPage p1, VisitedPage p2, double delta) {
		super(p1, p2,delta);
		// TODO Auto-generated constructor stub
	}
	
	public DeltaSimple(VisitedPage p1, VisitedPage p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computeDelta(VisitedPage p1, VisitedPage p2) {
		// TODO Auto-generated method stub
		System.out.println("1\n"+p1.getXmlDescr());
		System.out.println("2\n"+p2.getXmlDescr());
		double delta = p1.getXmlDescr().compareTo(p2.getXmlDescr());
		this.setDelta(Math.abs(delta));	
	}

}
