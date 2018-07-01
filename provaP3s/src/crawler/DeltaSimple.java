package crawler;

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
		double delta = p1.getXmlDescr().toString().compareTo(p2.getXmlDescr().toString());
		this.setDelta(delta);
		
	}

}
