package crawler;

public class Element {
	
	private String XPath;
	private String Value;
	private int nSimulations;
	
	public String getXPath() {
		return XPath;
	}
	public void setXPath(String xPath) {
		XPath = xPath;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public int getnSimulations() {
		return nSimulations;
	}
	public void setnSimulations(int nSimulations) {
		this.nSimulations = nSimulations;
	}

}
