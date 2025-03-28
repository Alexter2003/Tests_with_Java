package org.example.payments;

import org.junit.Test;

import static org.junit.Assert.*;

public class StrignUtilTest {
    @Test
    public void false_if_string_is_not_empty() {
        assertFalse(StrignUtil.isEmpty("test"));
    }

    @Test
    public void true_if_string_is_empty() {
        assertTrue(StrignUtil.isEmpty(""));
    }

    @Test
    public void true_if_string_is_null() {
        assertTrue(StrignUtil.isEmpty(null));
    }

    @Test
    public void true_if_string_is_whitespace() {
        assertTrue(StrignUtil.isEmpty("   "));
    }
}