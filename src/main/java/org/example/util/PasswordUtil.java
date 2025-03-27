package org.example.util;

public class PasswordUtil {

    public enum SecurityLeveL{
        WEAK, MEDUIM, STRONG
    }

    public static SecurityLeveL assessPassword(String password){
        if(password.length() < 8){
            return SecurityLeveL.WEAK;
        }
        if(password.matches("[a-zA-Z]+")){
            return SecurityLeveL.WEAK;
        }
        if(password.matches("[a-zA-Z0-9]+")){
            return SecurityLeveL.MEDUIM;
        }
        return SecurityLeveL.STRONG;
    }

}
