package webscraper.dto;


import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FoodItems implements Serializable {
    private final static int PLACES = 2;
    private BigDecimal total;
    private List<FoodItem> results;

    public FoodItems() {
        this.results = new ArrayList<>(); this.total = new BigDecimal("0.00");
    }

    public void addFoodItem(FoodItem foodItem) {
        this.results.add(foodItem);
        addToTotalPrice(foodItem);
        roundUpPrice();
    }

    private void addToTotalPrice(FoodItem foodItem) {
         this.total = this.total.add(foodItem.getUnitPrice());
    }

    @Override
    public String toString() {

       return "FoodItems{" +
                "total=" + total +
                ", results=" + results +
                '}';
    }

    private void roundUpPrice() {
        this.total = total.setScale(PLACES, RoundingMode.HALF_UP);
    }
}
