package org.example.util;

public class EmailUtil {

    public static Boolean isValidEmail(String email){
        if(email == null){
            throw new IllegalArgumentException("Email cannot be null");
        }

        if(email.length() <= 5) {
            return false;
        }

        if(!email.contains("@")){
            return false;
        }

        if(!email.contains(".")){
            return false;
        }

        if(email.contains(" ")){
            return false;
        }

        return true;
    }
}
