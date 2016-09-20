package com.tdd;

/**
 * Created by darkorajin on 19.09.16.
 */
public class Display {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {return text;}

    public void displayPrice(String priceAsText) {
        setText(priceAsText);
    }

    public void displayEmptyBarcodeMessage() {
        setText("Scanning error: barcode was empty");
    }

    public void displayProductNotFoundForBarcodeMessage(String barcode) {
        setText("product not found for " + barcode);
    }

    public void displayNoSaleInProgressMessage() {
        setText("No sale in progress. Try scanning a product.");
    }

    public void displayPurchaseTotal(String price) {
        setText("Total: " + price);
    }
}
