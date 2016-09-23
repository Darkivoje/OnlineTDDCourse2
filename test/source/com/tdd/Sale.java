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
        scannedPrice = catalog.findThenFormatPrice(barcode);
        if (scannedPrice == null) {
            display.displayProductNotFoundForBarcodeMessage(barcode);
        } else {
            display.displayPrice(formatMonetoryAmount(scannedPrice));
        }
    }

    private String formatMonetoryAmount(String priceAsText) {
        return priceAsText;
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
