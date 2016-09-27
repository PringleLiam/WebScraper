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
    private double totalPrice;
    private List<FoodItem> foodItems;

    public FoodItems() {
        this.foodItems = new ArrayList<>();
    }

    public void addFoodItem(FoodItem foodItem) {
        this.foodItems.add(foodItem);
        addToTotalPrice(foodItem);
        roundUpPrice();
    }

    private void addToTotalPrice(FoodItem foodItem) {
        totalPrice += foodItem.getPrice();
    }

    public void removeFoodItem(FoodItem foodItem) {
        this.foodItems.remove(foodItem);
        removeFromTotalPrice(foodItem);
        roundUpPrice();
    }

    private void removeFromTotalPrice(FoodItem foodItem) {
        totalPrice -= foodItem.getPrice();

    }

    private void roundUpPrice() {
        BigDecimal bigDecimal = new BigDecimal(this.getTotalPrice());
        bigDecimal = bigDecimal.setScale(PLACES, RoundingMode.HALF_UP);
        this.totalPrice = bigDecimal.doubleValue();
    }
}
