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

    public Map<String, String> getPricesAsTextByBarcode() {
        return pricesAsTextByBarcode;
    }

    public Integer findPrice(String barcode) {
        return pricesInCentsByBarcode.get(barcode);
    }
}
