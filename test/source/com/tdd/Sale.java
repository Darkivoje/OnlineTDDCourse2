package com.tdd;

/**
 * Created by darkorajin on 19.09.16.
 */
public class Sale {

    private Display display;
    private Catalog catalog;
    private String priceAsText;

    public Sale(Display display, Catalog catalog) {
        this.catalog = catalog;
        this.display = display;
    }


    public void onBarcode(String barcode) {

        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }
        priceAsText = catalog.findPrice(barcode);
        if (priceAsText == null) {
            display.displayProductNotFoundForBarcodeMessage(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    public void onTotal() {
        if (priceAsText == null)
        display.displayNoSaleInProgressMessage();
        else
            display.setText("Total: " + priceAsText);

    }

}
