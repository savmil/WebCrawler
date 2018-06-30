package crawler;

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

	//pattern strategy
	public abstract double computeDelta(VisitedPage p1,VisitedPage p2);
}
