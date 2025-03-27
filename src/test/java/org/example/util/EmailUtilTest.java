package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailUtilTest {

    @Test(expected =  IllegalArgumentException.class)
    public void  invalid_when_email_is_null(){
        Assert.assertEquals(false, EmailUtil.isValidEmail(null));
    }

    @Test
    public void invalid_when_email_has_less_than_5_characters(){
        Assert.assertEquals(false, EmailUtil.isValidEmail("a@b.c"));
    }

    @Test
    public void invalid_when_email_not_contains_at(){
        Assert.assertEquals(false, EmailUtil.isValidEmail("alexgmail.com"));
    }

    @Test
    public void invalid_when_email_not_contains_dot(){
        Assert.assertEquals(false, EmailUtil.isValidEmail("alex@gmailcom"));
    }

    @Test
    public void invalid_when_email_contains_space(){
        Assert.assertEquals(false, EmailUtil.isValidEmail("alex @gmail.com"));
    }
}