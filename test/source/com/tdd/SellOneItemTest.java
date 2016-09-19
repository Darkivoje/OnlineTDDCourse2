package com.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by darkorajin on 18.08.16.
 */
public class SellOneItemTest {

    private Display display;
    private Sale sale;

    @Before
    public void setUp() throws Exception {
        display = new Display();
        sale = new Sale(display, new Catalog(new HashMap<String, String>() {{
            put("12345", "$1.95");
            put("12346", "$2.95");
            put("12347", "$7.95");
        }}));
    }

    @Test
    public void testEveryBarcodeSamePrice() throws Exception {
        sale.onBarcode("12345");
        assertEquals(display.getText(), "$1.95");
    }

    @Test
    public void testSecondBarcode() throws Exception {
        sale.onBarcode("12346");
        assertEquals(display.getText(), "$2.95");
    }
    @Test
    public void testThirdBarcode() throws Exception {
        sale.onBarcode("12347");
        assertEquals(display.getText(), "$7.95");
    }

    @Test
    public void testProductNotFind() throws Exception {
        sale.onBarcode("23456");
        assertEquals(display.getText(), "product not found for 23456");
    }

    @Test
    public void testEmptyBarcode() throws Exception {
        Sale sale = new Sale(display, new Catalog(null));
        sale.onBarcode("");
        assertEquals("Scanning error: barcode was empty", display.getText());

    }


    public static class Catalog {
        private final Map<String, String> pricesByBarcode;

        private Catalog(Map<String, String> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public Map<String, String> getPricesByBarcode() {
            return pricesByBarcode;
        }

        public String findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
