package com.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

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
        Catalog catalog = new Catalog(Collections.singletonMap("12345",650));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("12345");
        sale.onTotal();

        assertEquals("Total: $6.50", display.getText());
    }

    @Test
    public void oneItemNotFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("12345",650));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("99999");
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }

    @Test
    public void severalItemsAllNotFound() throws Exception {
        Display display = new Display();
        Sale sale = new Sale(display, catalogWithoutBarcodes(
                "product you wont find",
                "another product you wont find",
                "yet another product you wont find"));

        sale.onBarcode("product you wont find");
        sale.onBarcode("another product you wont find");
        sale.onBarcode("yet another product you wont find");
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }

    private Catalog catalogWithoutBarcodes(String... barcodesToExclude) {
        return emptyCatalog();
    }

    private Catalog emptyCatalog() {
        return new Catalog(Collections.emptyMap());
    }
    
    @Test
    @Ignore("Refactoring")
    public void severalItemsAllFound() throws Exception {
        Catalog catalog = new Catalog(new HashMap<String, Integer>() {{
            put("1",850);
            put("2",1275);
            put("3",330);
        }});
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarcode("1");
        sale.onBarcode("2");
        sale.onBarcode("3");
        sale.onTotal();

        assertEquals("Total: $24.50", display.getText());

    }
}
