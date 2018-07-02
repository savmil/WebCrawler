package crawler;

public class NavigationStep {
	
	private Element event;
	private ErrorP errorBUT;
	private ErrorP errorBM;
	private IDelta delta;
	private VisitedPage rightPage; // Nel caso in cui si verifica un errore, occorre eventualmente salvare la pagina 
								   // in cui esso non si è verificato.

	public NavigationStep(IDelta delta) {
		super();
		this.delta = delta;
	}

	public NavigationStep(Element event) {
		super();
		this.event = event;
	}

	public void setErrorBUT(ErrorP e) {
		this.errorBUT = e;
	}
	
	public void setErrorBM(ErrorP e) {
		this.errorBM = e;
	}
	
	public void setDelta(IDelta delta) {
		this.delta = delta;
	}

	public void setRightPage(VisitedPage page) {
		this.rightPage = page;
	}

	public void setEvent(Element event) {
		this.event = event;
	}

	public ErrorP getErrorBUT() {
		return errorBUT;
	}

	public ErrorP getErrorBM() {
		return errorBM;
	}

	public IDelta getDelta() {
		return delta;
	}

	public VisitedPage getRightPage() {
		return rightPage;
	}

	public Element getEvent() {
		return event;
	}
}
