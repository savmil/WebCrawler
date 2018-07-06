package provaP3s;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//from  w ww .j a v a  2 s.  c  o  m
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXParseException;
public class provaXpath {

	  public static void main(String[] args) throws Exception {
	    List<String> names = new ArrayList<>();
	    URL oracle = new URL("http://www.repubblica.it");
	    InputStream is = oracle.openStream();
	    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	    domFactory.setNamespaceAware(true);
	    DocumentBuilder builder = domFactory.newDocumentBuilder();
	    Document doc=null;
	    try
	    {
	    	 doc = builder.parse(is);
	    }
	    catch (SAXParseException e) {
			// TODO: handle exception
		}
	    XPathFactory factory = XPathFactory.newInstance();
	    XPath xpath = factory.newXPath();
	    XPathExpression expr = xpath.compile("//*:*/@*");
	    Object result = expr.evaluate(doc, XPathConstants.NODESET);
	    NodeList nl = (NodeList) result;
	    for (int i = 0; i < nl.getLength(); i++) {
	      names.add(nl.item(i).getNodeName());
	      Node node = nl.item(i);
	      String path = "." + node.getNodeName() + " = " + node.getNodeValue();
	      node = ((Attr) node).getOwnerElement();
	      while (node != null) {
	        path = node.getNodeName() + '/' + path;
	        node = node.getParentNode();
	      }
	      System.out.println(path);
	    }
	  }
}
