package webscraper.dto;

import java.io.Serializable;

/**
 * Created by Liam on 22/09/2016.
 */
public class FoodItem implements Serializable {
    private String title;
    private String size;
    private String description;
    private String price;

    public FoodItem() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public FoodItem(String title, String size, String description, String price) {
        this.title = title;
        this.size = size;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
