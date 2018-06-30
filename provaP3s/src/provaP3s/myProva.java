package provaP3s;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.jdom.input;

public class myProva {

	public static void main(String[] args) {
		/*WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\posti\\Documents\\GitHub\\WebCrawler\\provaP3s\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.it");

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.close();
        driver.quit();*/
		
		String xml = "<message>HELLO!</message>";
		org.jdom.input.SAXBuilder saxBuilder = new SAXBuilder();
		try {
		    org.jdom.Document doc = saxBuilder.build(new StringReader(xml));
		    String message = doc.getRootElement().getText();
		    System.out.println(message);
		} catch (JDOMException e) {
		    // handle JDOMException
		} catch (IOException e) {
		    // handle IOException
		}

	}

}
