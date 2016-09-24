package com.tdd;

import java.util.Map;

/**
 * Created by darkorajin on 20.09.16.
 */
public class Catalog {
    private Map<String, Integer> pricesInCentsByBarcode;

    public Catalog(Map<String, Integer> pricesInCentsByBarcode) {
        this.pricesInCentsByBarcode = pricesInCentsByBarcode;
    }

    public Integer findPrice(String barcode) {
        return pricesInCentsByBarcode.get(barcode);
    }
}
