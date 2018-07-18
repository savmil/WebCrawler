package crawler;

import java.awt.Composite;

import javax.annotation.PostConstruct;

import crawler.UI.*;

public class Test {
	@PostConstruct
	public void controlli(Composite com)
	{
		
	}
	public static void main(String args[]){
		
		UIUser ui = new UIUserCL();
		//tinytuba.com
		ui.startTest("http://www.docenti.unina.it/", 4);
	}

}
