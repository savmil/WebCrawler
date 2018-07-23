package crawler.crawlerLogic.entity;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
	public void saveErrorP(String directory,int id)
	{
		try
		{
			PrintWriter visitedPage = new PrintWriter (directory+"\\"+id+".xml");
			visitedPage.write(getError());
			visitedPage.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}