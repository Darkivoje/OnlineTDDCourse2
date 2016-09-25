package com.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by darkorajin on 25.09.16.
 */
public class ComputePurchaseTotalTest {

    @Test
    public void zeroItems() throws Exception {
        assertEquals(0, computePurchaseTotal(Collections.<Integer>emptyList()));
    }

    @Test
    public void oneItem() throws Exception {
        assertEquals(795, computePurchaseTotal(Collections.singletonList(795)));
    }

    @Test
    public void severalItems() throws Exception {
        assertEquals(5450, computePurchaseTotal(Arrays.asList(2850, 1275, 1325)));
    }

    private int computePurchaseTotal(List<Integer> purchaseItemPrices) {
        return Sale.computePurchaseTotal(purchaseItemPrices).intValue();
    }
}
