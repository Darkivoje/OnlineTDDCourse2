package com.tdd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.Inflater;

/**
 * Created by darkorajin on 19.09.16.
 */
public class Sale {

    private Display display;
    private Catalog catalog;
    private Collection<Integer> pendingPurchaseItemPrices = new ArrayList<Integer>();

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
            pendingPurchaseItemPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        if (pendingPurchaseItemPrices.isEmpty()) {
            display.displayNoSaleInProgressMessage();
        } else {
            display.displayPurchaseTotal(pendingPurchaseTotal());
        }

    }

    private Integer pendingPurchaseTotal() {
        return computePurchaseTotal(pendingPurchaseItemPrices);
    }

    public static Integer computePurchaseTotal(Collection<Integer> purchaseItemPrices) {
        if (purchaseItemPrices.isEmpty())
            return 0;
        else if (purchaseItemPrices.size() == 1)
            return purchaseItemPrices.iterator().next();
        else
            return purchaseItemPrices.stream().reduce(new Integer(0), (sum, each) -> sum + each);
    }


}
