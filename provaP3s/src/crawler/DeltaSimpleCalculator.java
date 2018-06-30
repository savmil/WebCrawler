package crawler;

public class DeltaSimpleCalculator extends IDelta{

	public DeltaSimpleCalculator(VisitedPage p1, VisitedPage p2, double delta) {
		super(p1, p2,delta);
		// TODO Auto-generated constructor stub
	}
	
	public DeltaSimpleCalculator(VisitedPage p1, VisitedPage p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double computeDelta(VisitedPage p1, VisitedPage p2) {
		// TODO Auto-generated method stub
		double delta = p1.getXmlDescr().toString().compareTo(p2.getXmlDescr().toString());
		return delta;
	}

}
