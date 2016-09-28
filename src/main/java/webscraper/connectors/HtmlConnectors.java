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
    private static final int CONNECTION_TIMEOUT = 6000;
    private static final int CONNECTION_ATTEMPTS = 3;
    private static final int TIME_BETWEEN_REQUESTS = 60;


    public static Document getDocumentFromURL(String url) {
        Document document;
        URL urlAddress = getUrlFromString(url);
        document = fetchDocument(urlAddress);

        if (document != null) {
            return document;
        } else {
            throw new CouldNotConnectException("Couldn't connect after " + CONNECTION_ATTEMPTS + " attempts");
        }
    }

    private static Document fetchDocument(URL urlAddress) {
        Document document = null;
        for (int i = 0; i < CONNECTION_ATTEMPTS; i++) {
            pauseBetweenRequests(TIME_BETWEEN_REQUESTS);
            try {
                document = Jsoup.parse(urlAddress, CONNECTION_TIMEOUT);
            } catch (IOException e) {
                continue;
            }
            break;
        }
        return document;
    }

    private static void pauseBetweenRequests(int timeInMs) {
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
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

}
