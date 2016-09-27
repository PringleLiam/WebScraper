package webscraper;

import org.jsoup.nodes.Document;
import webscraper.parser.HtmlParser;
import webscraper.parser.RipeFruitParser;
import webscraper.connectors.HtmlConnectors;

import java.io.File;

/**
 * Created by Liam on 21/09/2016.
 */
public class RipeFruitRunner {

    public static void main(String[] args){
        HtmlConnectors htmlConnectors = new HtmlConnectors();
        HtmlParser htmlParser = new RipeFruitParser();
        Document doc = htmlConnectors.getDocumentFromFile(new File("test.html"));
        System.out.println(htmlParser.parseHtml(doc));

    }
}
