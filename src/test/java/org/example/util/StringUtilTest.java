package org.example.util;


import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public  void repeat_string_one_time() {
        String result = StringUtil.repeat("Hola", 1);
        Assert.assertEquals("Hola ", result);
    }

    @Test
    public void repeat_string_multiple_times() {
        String result = StringUtil.repeat("Hola", 3);
        Assert.assertEquals("Hola Hola Hola ", result);
    }

    @Test
    public void repeat_string_zero_times() {
        String result = StringUtil.repeat("Hola", 0);
        Assert.assertEquals("", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        String result = StringUtil.repeat("Hola", -1);
        Assert.assertEquals("", result);
    }
}