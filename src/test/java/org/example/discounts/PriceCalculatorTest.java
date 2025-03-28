package org.example.discounts;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorTest {
    PriceCalculator calculator;

    @Before
    public void setup() {
        calculator = new PriceCalculator();
    }

    @Test
    public void return_total_zero_if_there_are_no_prices() {
        assertThat( calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_sum_of_prices() {
        calculator.addPrice(10.2);
        calculator.addPrice(20.5);
        assertThat( calculator.getTotal(), is(30.7));
    }

    @Test
    public void apply_discount_to_prices() {
        calculator.addPrice(12.3);
        calculator.addPrice(32.5);

        calculator.setDiscount(50);
        assertThat( calculator.getTotal(), is( 22.4));
    }
}