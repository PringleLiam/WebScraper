package webscraper.selectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Liam on 22/09/2016.
 */
public class HtmlSelector {

    public Document getDocumentFromURL(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Document getDocumentFromFile(File file) {
        Document document = null;
        try {
            document = Jsoup.parse(file,"windows-1258");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
