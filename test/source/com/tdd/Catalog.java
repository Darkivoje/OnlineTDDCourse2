package com.tdd;

import java.util.Locale;
import java.util.Map;

/**
 * Created by darkorajin on 20.09.16.
 */
public class Catalog {
    private Map<String, String> pricesAsTextByBarcode;
    private Map<String, Integer> pricesInCentsByBarcode;

    public Catalog(Map<String, String> pricesAsTextByBarcode, Map<String, Integer> pricesInCentsByBarcode) {
        this.pricesAsTextByBarcode = pricesAsTextByBarcode;
        this.pricesInCentsByBarcode = pricesInCentsByBarcode;
    }

    public static String format(int priceInCents) {
        return String.format(Locale.US, "$%,.2f", priceInCents / 100.0d);
    }

    public Map<String, String> getPricesAsTextByBarcode() {
        return pricesAsTextByBarcode;
    }

    public Integer findPrice(String barcode) {
        return pricesInCentsByBarcode.get(barcode);
    }
}
