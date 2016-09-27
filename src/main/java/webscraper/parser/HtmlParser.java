package webscraper.parser;

import org.jsoup.nodes.Document;

/**
 * Created by Liam on 22/09/2016.
 */
public interface HtmlParser {
    String parseHtml(Document html);
}
