package com.tdd;

/**
 * Created by darkorajin on 19.09.16.
 */
public class Display {
    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public void displayPrice(String priceAsText) {
        setText(priceAsText);
    }

    public void displayEmptyBarcodeMessage() {
        setText("Scanning error: barcode was empty");
    }

    public void displayProductNotFoundForBarcodeMessage(String barcode) {
        setText("product not found for " + barcode);
    }
}
