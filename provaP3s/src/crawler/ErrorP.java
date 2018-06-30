package crawler;

import javax.xml.crypto.dsig.XMLObject;

public class ErrorP {
	
	private XMLObject error;

	
	public ErrorP(XMLObject error) {
		super();
		this.error = error;
	}
	public XMLObject getError() {
		return error;
	}

	public void setError(XMLObject error) {
		this.error = error;
	}
	
	
	
	
}
