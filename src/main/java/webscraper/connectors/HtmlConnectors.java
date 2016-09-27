package webscraper.connectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import webscraper.exceptions.CouldNotConnectException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Liam on 22/09/2016.
 */
public class HtmlConnectors {
    private static final int CONNECTION_TIMEOUT = 30000;
    private static final int CONNECTION_ATTEMPTS = 3;


    public static Document getDocumentFromURL(String url) {
        Document document = null;
        URL urlAddress = getUrlFromString(url);
        for (int i = 0; i < CONNECTION_ATTEMPTS; i++) {
            try {
                document = Jsoup.parse(urlAddress, CONNECTION_TIMEOUT);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
        if (document != null) {
            return document;
        } else {
            throw new CouldNotConnectException("Couldn't connect after "+ CONNECTION_ATTEMPTS +" attempts");
        }
    }

    private static URL getUrlFromString(String url) {
        URL urlAddress = null;
        try {
            urlAddress = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlAddress;
    }

    public Document getDocumentFromFile(File file) {
        Document document = null;
        try {
            document = Jsoup.parse(file, "windows-1258");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
