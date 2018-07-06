package crawler.converter;

import java.io.IOException;
import java.io.StringReader;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.InputSource;

public class XmlConverter 
{
	// la funzione riceve in ingresso la descrizione HTML della pagina (in formato stringa) e restituisce 
		// la descrizione XML della pagina (in formato stringa)
		public String html2xml(String HTMLPageSource){
	/*		String result = new String();
			
			StringReader frInHtml = new StringReader(HTMLPageSource);
			BufferedReader brInHtml = new BufferedReader(frInHtml);
			SAXBuilder saxBuilder = new SAXBuilder();
			//SAXBuilder saxBuilder = new SAXBuilder("org.ccil.cowan.tagsoup.Parser", false);
			XMLOutputter outputter = new XMLOutputter();
			try {
				Document jdomDocument = saxBuilder.build(brInHtml);
			    result = outputter.outputString(jdomDocument);
			}catch(Exception e){
				e.printStackTrace();
			}
			return result;*/
			
			Document doc=new Document();
			String xmls = new String();
			try{
				System.out.println(HTMLPageSource);
				StringReader xml = new StringReader(HTMLPageSource);
				SAXBuilder sb = new SAXBuilder();
	        	doc= sb.build(new InputSource(xml));
	        	
			}catch(IOException e){
				//e.printStackTrace();        	
			}catch(JDOMException e){
				//e.printStackTrace();     	
			}

	    	XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	    	xmls = outputter.outputString(doc);
			return xmls;
			
	    	/* Questo codice serve a stampare su un file xml
	        FileWriter fwOutXml = new FileWriter("output.xml");
	    	BufferedWriter bwOutXml = new BufferedWriter(fwOutXml);
	    	outputter.output((org.jdom2.Document) doc, bwOutXml);
	    	*/
		}
}
