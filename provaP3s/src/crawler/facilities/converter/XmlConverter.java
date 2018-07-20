package crawler.facilities.converter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class XmlConverter 
{
	// la funzione riceve in ingresso la descrizione HTML della pagina (in formato stringa) e restituisce 
		// la descrizione XML della pagina (in formato stringa)
		public String string2xml(String string){
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
			
			Document doc=Jsoup.parse(string);
			//System.out.println(HTMLPageSource);
			doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml); 
			//System.out.println(doc.html());
		    return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"+doc.html();
			/*String xmls = new String();
			try{
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
			return xmls;*/
			
	    	/* Questo codice serve a stampare su un file xml
	        FileWriter fwOutXml = new FileWriter("output.xml");
	    	BufferedWriter bwOutXml = new BufferedWriter(fwOutXml);
	    	outputter.output((org.jdom2.Document) doc, bwOutXml);
	    	*/
		}
}
