package webscraper.dto;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Liam on 28/09/2016.
 */
public class FoodItemsTest {

    @Test
    public void testAddFoodItem() throws Exception {
        FoodItems foodItems = new FoodItems();

        FoodItem foodItem = new FoodItem("test", "93kb", "test food item1", 3.3);
        foodItems.addFoodItem(foodItem);
        Assert.assertTrue(isFoodItemInFoodItems(foodItem, foodItems));
    }

    @Test
    public void testTotalPrice() {
        FoodItems foodItems = new FoodItems();

        FoodItem foodItem = new FoodItem("test", "93kb", "test food item1", 3.3);
        foodItems.addFoodItem(foodItem);
        foodItem = new FoodItem("test", "93kb", "test food item1", 6.7);
        foodItems.addFoodItem(foodItem);

        Assert.assertEquals(foodItems.getTotal(), new BigDecimal("10.00"));
    }

    private boolean isFoodItemInFoodItems(FoodItem foodItem, FoodItems foodItems) {
        boolean isFound = false;
        for (FoodItem currentFoodItem : foodItems.getResults()) {
            if (currentFoodItem.equals(foodItem)) {
                isFound = true;
            }
        }
        return isFound;
    }
}