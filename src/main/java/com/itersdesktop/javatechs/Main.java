package com.itersdesktop.javatechs;//package com.test;

import com.itersdesktop.javatechs.oop.*;

public class Main {

    public static void main(String[] args) {
        //testEbiEntryBuilder();
        testBigIntegerAddition();
    }

    private static void testBigIntegerAddition() {
        //new BigIntAddition().test();
//        boolean k = new Solution().isPalindrome(1001);
        boolean k = new Solution().isPalindrome(88888);
        System.out.println(k);
    }

    private static void testEbiEntryBuilder() {
        EbiEntryBuilder ebiBuilder = new EbiEntryBuilder();
        ebiBuilder.index();

        OmicsDiEntryBuilder omicsdiBuilder = new OmicsDiEntryBuilder();
        omicsdiBuilder.index();
    }


}

class Solution {
    private static int[] convert2Array(int guess) {
        String temp = Integer.toString(guess);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x <= 9) return true;
        int[] number = convert2Array(x);
        int length = number.length;
        if (length == 2) {
            return number[0] == number[1];
        } else if (length == 3) {
            return number[0] == number[2];
        } else {
            int i, j;
            i = (int) (double) (length / 2) - 1;
            j = (int) (double) (length / 2);
            if (length % 2 == 1) { j += 1; }
            while (number[i] == number[j] && i > 0) {
                i--;
                j++;
            }
            return i == 0 && j == length - 1;
        }
    }
}