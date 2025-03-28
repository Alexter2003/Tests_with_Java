package org.example.util;

public class FizzBuzzUtil {
    public enum FizzBuzzResult {
        FIZZ, BUZZ, FIZZ_BUZZ, OTHER
    }

    public static FizzBuzzResult fizzBuzz(int number){
        if(number % 3 == 0 && number % 5 == 0){
            return FizzBuzzResult.FIZZ_BUZZ;
        }else if(number % 3 == 0){
            return FizzBuzzResult.FIZZ;
        }else if(number % 5 == 0) {
            return FizzBuzzResult.BUZZ;
        } else {
            return FizzBuzzResult.OTHER;
        }

    }
}
