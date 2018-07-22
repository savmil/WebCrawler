package test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import crawler.crawlerLogic.entity.AnchorLink;
import crawler.crawlerLogic.entity.Element;
import crawler.crawlerLogic.entity.NavigationStep;
import crawler.crawlerLogic.entity.Report;
import crawler.crawlerLogic.entity.pages.RootPage;
/*import crawler.crawlerLogic.entity.pages.RootPageBM;
import crawler.crawlerLogic.entity.pages.RootPageBUT;*/
import crawler.crawlerLogic.manager.ComputeManager;
import crawler.facilities.driver.TriggerResult;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComputeManagerTest {

	@Test
	public void testComputeRootPageRootPageDelta0() {
		ComputeManager computemanger=new ComputeManager();
		//RootPageBM rootBM=new RootPageBM("", "\r\n" + 
		RootPage rootBM=new RootPage("", "\r\n" + 
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<!-- \r\n" + 
				"    What were you expecting?\r\n" + 
				"    Site by: @mxmcd\r\n" + 
				" -->\r\n" + 
				"    <head>\r\n" + 
				"        <meta charset=\"utf-8\">\r\n" + 
				"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"        <title>Tiny Tuba</title>\r\n" + 
				"        <meta name=\"description\" content=\"Tiny Tuba\">\r\n" + 
				"        <style type=\"text/css\">\r\n" + 
				"            html, body, table {\r\n" + 
				"                height: 100%;\r\n" + 
				"                width: 100%;\r\n" + 
				"                margin: 0px;\r\n" + 
				"                padding: 0px;\r\n" + 
				"                text-align: center;\r\n" + 
				"            }\r\n" + 
				"            audio {\r\n" + 
				"                display: none;\r\n" + 
				"                position: fixed;\r\n" + 
				"                margin-left: 1000000px;\r\n" + 
				"            }\r\n" + 
				"            img {\r\n" + 
				"                cursor: pointer;\r\n" + 
				"            }\r\n" + 
				"        </style>\r\n" + 
				"        <script type=\"text/javascript\">\r\n" + 
				"            var playCount = 0\r\n" + 
				"            function init() {\r\n" + 
				"                var tuba=document.getElementById(\"tuba\"); \r\n" + 
				"            }\r\n" + 
				"            function playSound() { \r\n" + 
				"                tuba.load();\r\n" + 
				"                tuba.play();\r\n" + 
				"                playCount++\r\n" + 
				"            }                 \r\n" + 
				"        </script>\r\n" + 
				"\r\n" + 
				"    </head>\r\n" + 
				"    <body onload=\"init();\">\r\n" + 
				"        <table>\r\n" + 
				"            <tr>\r\n" + 
				"                <td>\r\n" + 
				"                    <img onclick=\"playSound();\" src=\"tuba.jpg\" alt=\"\">\r\n" + 
				"                    <audio controls=\"controls\" id='tuba'>\r\n" + 
				"                        <source src=\"tuba.mp3\" type=\"audio/mp3\">\r\n" + 
				"                    </audio>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"        </table>\r\n" + 
				"    </body>\r\n" + 
				"</html>\r\n");
		
		//RootPageBUT rootBUT=new RootPageBUT("", "\r\n" + 
		RootPage rootBUT=new RootPage("","\r\n" + 
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<!-- \r\n" + 
				"    What were you expecting?\r\n" + 
				"    Site by: @mxmcd\r\n" + 
				" -->\r\n" + 
				"    <head>\r\n" + 
				"        <meta charset=\"utf-8\">\r\n" + 
				"        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"        <title>Tiny Tuba</title>\r\n" + 
				"        <meta name=\"description\" content=\"Tiny Tuba\">\r\n" + 
				"        <style type=\"text/css\">\r\n" + 
				"            html, body, table {\r\n" + 
				"                height: 100%;\r\n" + 
				"                width: 100%;\r\n" + 
				"                margin: 0px;\r\n" + 
				"                padding: 0px;\r\n" + 
				"                text-align: center;\r\n" + 
				"            }\r\n" + 
				"            audio {\r\n" + 
				"                display: none;\r\n" + 
				"                position: fixed;\r\n" + 
				"                margin-left: 1000000px;\r\n" + 
				"            }\r\n" + 
				"            img {\r\n" + 
				"                cursor: pointer;\r\n" + 
				"            }\r\n" + 
				"        </style>\r\n" + 
				"        <script type=\"text/javascript\">\r\n" + 
				"            var playCount = 0\r\n" + 
				"            function init() {\r\n" + 
				"                var tuba=document.getElementById(\"tuba\"); \r\n" + 
				"            }\r\n" + 
				"            function playSound() { \r\n" + 
				"                tuba.load();\r\n" + 
				"                tuba.play();\r\n" + 
				"                playCount++\r\n" + 
				"            }                 \r\n" + 
				"        </script>\r\n" + 
				"\r\n" + 
				"    </head>\r\n" + 
				"    <body onload=\"init();\">\r\n" + 
				"        <table>\r\n" + 
				"            <tr>\r\n" + 
				"                <td>\r\n" + 
				"                    <img onclick=\"playSound();\" src=\"tuba.jpg\" alt=\"\">\r\n" + 
				"                    <audio controls=\"controls\" id='tuba'>\r\n" + 
				"                        <source src=\"tuba.mp3\" type=\"audio/mp3\">\r\n" + 
				"                    </audio>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"        </table>\r\n" + 
				"    </body>\r\n" + 
				"</html>\r\n");
		computemanger.compute(rootBM, rootBUT);
		assertEquals("0.0",Double.toString(Report.getInstance().getSteps().get(3).getDelta().getDelta()) );
	}

	@Test
	public void testComputeElementHashtableOfStringTriggerResultTwoPageOK() 
	{
		ComputeManager computemanager=new ComputeManager();
		Element element= new AnchorLink();
		TriggerResult triggerc= new TriggerResult("test", false, "\\a");
		TriggerResult triggerf= new TriggerResult("test1", false, "\\a");
		Hashtable<String, TriggerResult> surfResult=new Hashtable<>();
		surfResult.put("[SurfManagerThreadChrome]",triggerc);
		surfResult.put("[SurfManagerThreadFirefox]",triggerf);
		computemanager.compute(element, surfResult);
		NavigationStep nav=Report.getInstance().getSteps().get(2);
		assertEquals("test",nav.getDelta().getP1().getXmlDescr());
		assertEquals("test1",nav.getDelta().getP2().getXmlDescr());
		assertEquals("\\a",nav.getEvent().getXPath());
		
	}
	@Test
	public void testComputeElementHashtableOfStringTriggerResultOneErrorBUT() 
	{
		ComputeManager computemanager=new ComputeManager();
		Element element= new AnchorLink();
		TriggerResult triggerc= new TriggerResult("test", false, "\\a");
		TriggerResult triggerf= new TriggerResult("err", true, "\\a");
		Hashtable<String, TriggerResult> surfResult=new Hashtable<>();
		surfResult.put("[SurfManagerThreadChrome]",triggerc);
		surfResult.put("[SurfManagerThreadFirefox]",triggerf);
		computemanager.compute(element, surfResult);
		NavigationStep nav=Report.getInstance().getSteps().get(1);
		assertEquals("test",nav.getRightPage().getXmlDescr());
		assertEquals("err",nav.getErrorBUT().getError());
		assertEquals("\\a",nav.getEvent().getXPath());
		
	}
	@Test
	public void testComputeElementHashtableOfStringTriggerResultOneErrorBM() 
	{
		ComputeManager computemanager=new ComputeManager();
		Element element= new AnchorLink();
		TriggerResult triggerc= new TriggerResult("err", true, "\\a");
		TriggerResult triggerf= new TriggerResult("test", false, "\\a");
		Hashtable<String, TriggerResult> surfResult=new Hashtable<>();
		surfResult.put("[SurfManagerThreadChrome]",triggerc);
		surfResult.put("[SurfManagerThreadFirefox]",triggerf);
		computemanager.compute(element, surfResult);
		NavigationStep nav=Report.getInstance().getSteps().get(0);
		assertEquals("test",nav.getRightPage().getXmlDescr());
		assertEquals("err",nav.getErrorBM().getError());
		assertEquals("\\a",nav.getEvent().getXPath());
		
	}

}
