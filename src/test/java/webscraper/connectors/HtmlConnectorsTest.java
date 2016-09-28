package webscraper.connectors;


import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Liam on 28/09/2016.
 */
public class HtmlConnectorsTest {

    @Test
    public void testGetDocumentFromURL() throws Exception {
        Document doc = HtmlConnectors.getDocumentFromURL("http://www.google.com");
        Assert.assertNotNull(doc);
    }


}