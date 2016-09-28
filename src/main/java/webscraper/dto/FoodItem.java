package webscraper.dto;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Liam on 22/09/2016.
 */
public class FoodItem implements Serializable {
    @Getter
    private String title;

    @Getter
    private String size;

    @Getter
    private String description;
    private BigDecimal unit_price;

    public FoodItem() {
    }

    public FoodItem(String title, String size, String description, double unit_price) {
        this.title = title;
        this.size = size;
        this.description = description;
        this.unit_price = new BigDecimal(Double.toString(unit_price));
    }

    public BigDecimal getUnitPrice() {
        return unit_price;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", description='" + description + '\'' +
                ", unit_price='" + unit_price + '\'' +
                '}';
    }
}
