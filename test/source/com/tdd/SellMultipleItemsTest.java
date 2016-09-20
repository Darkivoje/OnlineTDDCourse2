package com.tdd;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by darkorajin on 19.09.16.
 */
public class SellMultipleItemsTest {
    @Test
    public void zeroItems() throws Exception {
        Display display = new Display();
        Sale sale = new Sale(display, null);
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());

    }

    @Test
    public void sellOneItemTest() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("12345","$6.50"));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);
        sale.onBarcode("12345");
        sale.onTotal();
        assertEquals("Total: $6.50", display.getText());

    }
}