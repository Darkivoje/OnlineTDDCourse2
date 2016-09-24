package com.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
                {418976 , "$4,189.76"},
                {210832281 , "$2,108,322.81"},
        });
    }

    @Test
    public void test() throws Exception {
        assertEquals(expectedFormatedPrice, Display.format(priceInCents));
    }


}
