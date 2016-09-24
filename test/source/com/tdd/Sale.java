package com.tdd;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by darkorajin on 19.09.16.
 */
public class Sale {

    private Display display;
    private Catalog catalog;
    private Collection<Integer> scannedPrices = new ArrayList<Integer>();

    public Sale(Display display, Catalog catalog) {
        this.catalog = catalog;
        this.display = display;
    }


    public void onBarcode(String barcode) {

        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }
        Integer priceInCents = catalog.findPrice(barcode);
        if ( priceInCents == null) {
            display.displayProductNotFoundForBarcodeMessage(barcode);
        } else {
            scannedPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        boolean saleInProgress = (!scannedPrices.isEmpty());
        if (saleInProgress) {
            display.displayPurchaseTotal(Display.format(scannedPrices.iterator().next()));
        } else {
            display.displayNoSaleInProgressMessage();
        }

    }

}
