package org.example.util;

import org.junit.Assert;
import org.junit.Test;


import static org.example.util.FizzBuzzUtil.FizzBuzzResult.*;

public class FizzBuzzUtilTest {
    @Test
    public void number_divisible_by_3_returns_fizz(){
        Assert.assertEquals(FIZZ, FizzBuzzUtil.fizzBuzz(3));
    }

    @Test
    public void number_divisible_by_5_returns_buzz(){
        Assert.assertEquals(BUZZ, FizzBuzzUtil.fizzBuzz(5));
    }

    @Test
    public void number_divisible_by_3_and_3_returns_fizz_buzz(){
        Assert.assertEquals(FIZZ_BUZZ, FizzBuzzUtil.fizzBuzz(15));
    }

    @Test
    public void number_not_divisible_by_3_or_5_returns_other(){
        Assert.assertEquals(OTHER, FizzBuzzUtil.fizzBuzz(7));
    }

}