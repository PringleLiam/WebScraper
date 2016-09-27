package webscraper.currency;

import java.util.Currency;

/**
 * Created by Liam on 25/09/2016.
 */
public class CurrencyHandler {


    public static double getUnformattedPrice(Currency currency, String price) {
        String[] strings = price.split(currency.getSymbol());
        if (strings.length > 1) {
            return getDoubleValue(strings[1]);
        } else {
            return getDoubleValue(price);
        }
    }

    private static double getDoubleValue(String price) {
        double doubleValue;
        try {
            doubleValue = Double.parseDouble(price);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new NumberFormatException("The Price could not be formatted");
        }
        return doubleValue;
    }
}
