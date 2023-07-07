package com.techelevator;

import java.util.Locale;

public class Example2 {

    /*
	 1. Given a string, return true if the first and last characters of the string are the letter o (upper or
	 lower case). Ignore any leading or trailing spaces.

	 roundOnBothEnds("Ohio") → true
	 roundOnBothEnds("    OREO ") → true
	 roundOnBothEnds("ooooo!") → false
	*/
    public boolean roundOnBothEnds(String input) {
        input = input.trim();
        input = input.toLowerCase();

        boolean firstO = input.charAt(0) == 'o';
        boolean lastO = input.charAt(input.length() - 1) == 'o';

//        boolean firstO = input.startsWith("o");
//        boolean lastO = input.endsWith("o");

        return firstO && lastO;
    }

    /*
	 2. Given two strings, append them together (known as "concatenation") and return the result.
	 However, if the concatenation creates a double-char, then omit one of the chars, so "abc" and
	 "cat" yields "abcat".

	 conCat("abc", "cat") → "abcat"
	 conCat("dog", "cat") → "dogcat"
	 conCat("abc", "") → "abc"
	*/
    public String conCat(String a, String b) {

        if (a.length()> 0 && b.length() > 0) {
            char lastOfA = a.charAt(a.length() -1);
            char firstOfB = b.charAt(0);
            if (lastOfA == firstOfB) {
                return a + b.substring(1);
            }
        }
        return a + b;
    }

    /*
     3. Given a string, return true if the number of appearances of "is" anywhere in the string is equal to
     the number of appearances of "not" anywhere in the string (case sensitive).

     equalIsNot("This is not") → false
     equalIsNot("This is notnot") → true
     equalIsNot("noisxxnotyynotxisi") → true
    */
    public boolean equalIsNot(String str) {
        int isCount = 0;
        int notCount = 0;

        int i = str.indexOf("is");
        while (i > -1) {
            isCount++;
            i = str.indexOf("is", i + 2);
        }

        i = str.indexOf("not");
        while (i > -1) {
            notCount++;
            i = str.indexOf("not", i + 3);
        }

        return isCount == notCount;
    }

}
