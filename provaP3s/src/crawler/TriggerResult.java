package crawler;

// l'oggetto incapsula il risultato della funzione trigger del driver
public class TriggerResult {
	
	private String result;	//xmlDescr del risultato
	private boolean isError;
	
	public TriggerResult(String result, boolean isError) {
		super();
		this.result = result;
		this.isError = isError;
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
