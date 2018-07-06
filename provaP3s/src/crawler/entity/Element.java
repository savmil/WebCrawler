package crawler.entity;

public class Element {
	
	private String XPath;
	private String Value;
	private int nSimulations;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
