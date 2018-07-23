package crawler.facilities.converter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class XmlConverter 
{
	// la funzione riceve in ingresso la descrizione HTML della pagina (in formato stringa) e restituisce 
		// la descrizione XML della pagina (in formato stringa)
		public String string2xml(String string){
			Document doc=Jsoup.parse(string);
		
			doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml); 
			
		    return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"+doc.html();
		}
}
