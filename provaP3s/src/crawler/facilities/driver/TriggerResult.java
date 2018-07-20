package crawler.facilities.driver;

// l'oggetto incapsula il risultato della funzione trigger del driver
public class TriggerResult {
	
	private String result;	//xmlDescr del risultato
	private boolean isError;
	private String xpath;
	public TriggerResult(String result, boolean isError, String xpath) {
		super();
		this.result = result;
		this.isError = isError;
		this.xpath = xpath;
	}
	
	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public boolean getIsError() {
		return isError;
	}
	public void setIsError(boolean isError) {
		this.isError = isError;
	}	
}
