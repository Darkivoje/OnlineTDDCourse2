package com.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FormatMonetaryAmountTest {
    private final int priceInCents;
    private final String expectedFormatedPrice;

    public FormatMonetaryAmountTest(int priceInCents, String expectedFormatedPrice) {
        this.priceInCents = priceInCents;
        this.expectedFormatedPrice = expectedFormatedPrice;
    }

    @Parameterized.Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {520 , "$5.20"},
                {400 , "$4.00"},
                {002 , "$0.02"},
                {37 , "$0.37"},
        });
    }

    @Test
    public void test() throws Exception {
        assertEquals(expectedFormatedPrice, format(priceInCents));

    }

    private static String format(int priceInCents) {
        return String.format(Locale.US,"$%.2f", priceInCents / 100.0d);
    }


}
