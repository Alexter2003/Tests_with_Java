package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import static org.example.util.PasswordUtil.SecurityLeveL.*;


public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_tellers(){
        Assert.assertEquals(WEAK , PasswordUtil.assessPassword("123AA!"));
    }

    @Test
    public void weak_when_has_only_letters(){
        Assert.assertEquals(WEAK , PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        Assert.assertEquals(MEDUIM , PasswordUtil.assessPassword("ABCDEF12345"));
    }

    @Test
    public void medium_when_has_letters_numbers_and_symbols(){
        Assert.assertEquals(STRONG , PasswordUtil.assessPassword("ABCDEF12345!"));
    }

}