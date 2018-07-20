package crawler.entity;

public class ErrorP {
	
	private String Exception;	//xmlDescr dell'errore
	private int id;
	public ErrorP(String Exception,int id) {
		super();
		this.Exception = Exception;
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getError() {
		return Exception;
	}

	public void setError(String error) {
		this.Exception = error;
	}	
}
