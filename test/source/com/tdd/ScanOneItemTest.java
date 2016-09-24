package com.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by darkorajin on 18.08.16.
 */
public class ScanOneItemTest {

    private Display display;
    private Sale sale;

    @Before
    public void setUp() throws Exception {
        display = new Display();
        sale = new Sale(display, new Catalog(new HashMap<String, Integer>() {{
            put("12345", 195);
            put("12346", 295);
            put("12347", 795);
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


}
