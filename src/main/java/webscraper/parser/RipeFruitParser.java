package webscraper.parser;

import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import webscraper.connectors.HtmlConnectors;
import webscraper.dto.FoodItem;
import webscraper.dto.FoodItems;

import java.io.IOException;

/**
 * Created by Liam on 22/09/2016.
 */
public class RipeFruitParser implements HtmlParser {


    @Override
    public String parseHtml(Document html) {
        ObjectMapper objectMapper = new ObjectMapper();
        FoodItems foodItems = selectFoodItems(html);

        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(foodItems);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonString;
    }

    private FoodItems selectFoodItems(Document html) {
        Elements products = html.select(".product");
        FoodItems foodItems = new FoodItems();
        for (Element element : products) {
            String url = getUrl(element);
            Document innerDocument = getInnerDocument(url);
            foodItems.addFoodItem(selectFoodItem(element, innerDocument));
        }
        return foodItems;
    }

    private FoodItem selectFoodItem(Element element, Document innerDocument) {
        FoodItem foodItem = new FoodItem();
        if (innerDocument != null) {
            foodItem = new FoodItem(selectTitle(element), getSizeInKB(innerDocument), selectDescription(innerDocument), selectPrice(element));
        }
        return foodItem;
    }

    private String getUrl(Element element) {
        return element.select("a[href]").attr("href");
    }

    private Document getInnerDocument(String url) {
        return HtmlConnectors.getDocumentFromURL(url);
    }

    private double selectPrice(Element element) {
      String priceString = element.select(".priceTab .pricePerUnit").text();
      priceString = priceString.replaceAll("[^\\d.]", "");
      return Double.parseDouble(priceString);
    }

    private String getSizeInKB(Document innerDocument) {
        return (innerDocument.html().getBytes().length) / 1000 + "kb";
    }

    private String selectTitle(Element element) {
        return element.select("a[href]").text();
    }

    private String selectDescription(Document innerDocument) {
        return innerDocument.select(".productText").select("p").get(0).text();
    }
}
