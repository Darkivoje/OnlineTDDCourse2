package com.tdd;

/**
 * Created by darkorajin on 19.09.16.
 */
public class Sale {

    private Display display;
    private Catalog catalog;
    private String scannedPrice;

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
            scannedPrice = Display.format(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        boolean saleInProgress = (scannedPrice != null);
        if (saleInProgress) {
            display.displayPurchaseTotal(scannedPrice);
        } else {
            display.displayNoSaleInProgressMessage();
        }

    }

}
