package com.tdd;

import org.junit.Test;

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
}
