package com.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FormatMonetaryAmountTest {
    private final int priceInCents;
    private final String expectedFormatedPrice;

    public FormatMonetaryAmountTest(int priceInCents, String expectedFormatedPrice) {
        this.priceInCents = priceInCents;
        this.expectedFormatedPrice = expectedFormatedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Collections.singletonList(new Object[] {
            789, "$7.89"
        });
    }

    @Test
    public void test() throws Exception {
        assertEquals(expectedFormatedPrice, format(priceInCents));

    }

    private static String format(int priceInCents) {
        return "$7.89";
    }


}
