package com.tdd;

/**
 * Created by darkorajin on 19.09.16.
 */
public class Sale {

    private Display display;
    private ScanOneItemTest.Catalog catalog;

    public Sale(Display display, ScanOneItemTest.Catalog catalog) {
        this.catalog = catalog;
        this.display = display;
    }


    public void onBarcode(String barcode) {

        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }
        String priceAsText = catalog.findPrice(barcode);
        if (priceAsText == null) {
            display.displayProductNotFoundForBarcodeMessage(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    public void onTotal() {
        display.displayNoSaleInProgressMessage();

    }

}
