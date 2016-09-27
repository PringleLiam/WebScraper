package webscraper;

import org.jsoup.nodes.Document;
import webscraper.connectors.HtmlConnectors;
import webscraper.parser.HtmlParser;
import webscraper.parser.RipeFruitParser;

/**
 * Created by Liam on 21/09/2016.
 */
public class RipeFruitRunner {

    public static void main(String[] args){
        HtmlParser htmlParser = new RipeFruitParser();
        Document doc = HtmlConnectors.getDocumentFromURL("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html");
        System.out.println(htmlParser.parseHtml(doc));

    }
}
