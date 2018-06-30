package crawler;

public class NavigationStep {
	private ErrorP errorBUT;
	private ErrorP errorBM;
	private IDelta delta;
	private VisitedPage rightPage; // Nel caso in cui si verifica un errore, occorre eventualmente salvare la pagina in cui esso non si è verificato.
	private Element event;
	
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

}
