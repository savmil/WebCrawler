package crawler.entity;

public class ErrorP {
	
	private String error;	//xmlDescr dell'errore
	private int id;
	public ErrorP(String error,int id) {
		super();
		this.error = error;
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}	
}
