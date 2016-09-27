package webscraper.dto;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by Liam on 22/09/2016.
 */
@Getter
public class FoodItem implements Serializable {
    private String title;
    private String size;
    private String description;
    private double price;

    public FoodItem() {
    }

    public FoodItem(String title, String size, String description, double price) {
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
