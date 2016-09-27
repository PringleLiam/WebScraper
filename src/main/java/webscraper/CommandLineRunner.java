package webscraper;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import webscraper.parser.HtmlParser;
import webscraper.parser.RipeFruitParser;
import webscraper.selectors.HtmlSelector;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Created by Liam on 21/09/2016.
 */
public class CommandLineRunner {

    public static void main(String[] args){
        HtmlSelector htmlSelector = new HtmlSelector();
        HtmlParser htmlParser = new RipeFruitParser();
        Document doc = htmlSelector.getDocumentFromFile(new File("test.html"));
        System.out.println(htmlParser.parseHtml(doc));

    }
}
