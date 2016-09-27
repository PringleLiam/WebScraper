package webscraper.parser;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import webscraper.dto.FoodItem;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Liam on 22/09/2016.
 */
public class RipeFruitParser implements HtmlParser {
    @Override
    public String parseHtml(Document html) {
        String price = html.select(".priceTab").select(".pricePerUnit").get(0).childNode(0).outerHtml();
        ObjectMapper objectMapper = new ObjectMapper();
        FoodItem foodItem = new FoodItem();

        html.select(".product").get(0).select("a[href]");

        Elements products = html.select(".product");
        for (Element element : products) {
            String url = element.select("a[href]").attr("href");

            Document innerDocument = null;
            try {
                innerDocument = Jsoup.parse(new URL(url), 6000);
            } catch (IOException e) {
                e.printStackTrace();
            }

                int size = innerDocument.html().getBytes().length;

                price = element.select(".priceTab .pricePerUnit").text();

                foodItem.setPrice(price);
                foodItem.setTitle(element.select("a[href]").text());
                foodItem.setDescription(innerDocument.select(".productText").select("p").get(0).text());
                foodItem.setSize(size/1000 + "kb");
                System.out.println(foodItem);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(foodItem);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonString;
    }
}
