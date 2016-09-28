package webscraper.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webscraper.connectors.HtmlConnectors;

import java.io.File;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

/**
 * Created by Liam on 28/09/2016.
 */
public class RipeFruitParserTest {

    private HtmlParser ripeFruitParser;

    @Before
    public void setUp(){
        ripeFruitParser = new RipeFruitParser();
    }


    @Test
    public void testParseHtml() throws Exception {
        File html = new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "test.html");
        Document document = Jsoup.parse(html, Charset.defaultCharset().toString());
        String ripeFruitJsonString = ripeFruitParser.parseHtml(document);

        Assert.assertEquals("{\"total\":15.10,\"results\":[{\"title\":\"Sainsbury's Apricot Ripe & Ready x5\",\"size\":\"35kb\",\"description\":\"Apricots\",\"unitPrice\":3.5},{\"title\":\"Sainsbury's Avocado Ripe & Ready XL Loose 300g\",\"size\":\"36kb\",\"description\":\"Avocados\",\"unitPrice\":1.5},{\"title\":\"Sainsbury's Avocado, Ripe & Ready x2\",\"size\":\"40kb\",\"description\":\"Avocados\",\"unitPrice\":1.8},{\"title\":\"Sainsbury's Avocados, Ripe & Ready x4\",\"size\":\"36kb\",\"description\":\"Avocados\",\"unitPrice\":3.2},{\"title\":\"Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)\",\"size\":\"36kb\",\"description\":\"Conference\",\"unitPrice\":1.5},{\"title\":\"Sainsbury's Golden Kiwi x4\",\"size\":\"36kb\",\"description\":\"Gold Kiwi\",\"unitPrice\":1.8},{\"title\":\"Sainsbury's Kiwi Fruit, Ripe & Ready x4\",\"size\":\"36kb\",\"description\":\"Kiwi\",\"unitPrice\":1.8}]}",ripeFruitJsonString);
    }
}