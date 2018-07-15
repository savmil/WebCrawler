
package crawler.entity.delta;

import crawler.entity.pages.VisitedPage;

public abstract class IDelta {
	
	private VisitedPage p1;
	private VisitedPage p2;
	private double delta;
	
	public IDelta(VisitedPage p1, VisitedPage p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	public IDelta(VisitedPage p1, VisitedPage p2, double delta) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.delta = delta;
	}

	public VisitedPage getP1() {
		return p1;
	}
	public void setP1(VisitedPage p1) {
		this.p1 = p1;
	}
	public VisitedPage getP2() {
		return p2;
	}
	public void setP2(VisitedPage p2) {
		this.p2 = p2;
	}
	public double getDelta() {
		return delta;
	}
	public void setDelta(double delta) {
		this.delta = delta;
	}
	
	//pattern strategy
	public abstract void computeDelta(VisitedPage p1,VisitedPage p2);
}
