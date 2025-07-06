package com.itersdesktop.javatechs;//package com.test;

import com.itersdesktop.javatechs.oop.EbiEntryBuilder;
import com.itersdesktop.javatechs.oop.OmicsDiEntryBuilder;
import com.itersdesktop.javatechs.quartz.MyProgram;
import org.quartz.SchedulerException;

public class Main {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        testEbiEntryBuilder();
        testBigIntegerAddition();
        MyProgram.run();
    }

    private static void testBigIntegerAddition() {
        final String message = "Test Addition For The Big Integer";
        System.out.println(message);
        // new BigIntAddition().test();
        // boolean k = new Solution().isPalindrome(1001);
        boolean k = new Solution().isPalindrome(88888);
        System.out.println(k);
    }

    private static void testEbiEntryBuilder() {
        final String message = "Test EBI EntryBuilder";
        System.out.println(message);
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
            if (length % 2 == 1) {
                j += 1;
            }
            while (number[i] == number[j] && i > 0) {
                i--;
                j++;
            }
            return i == 0 && j == length - 1;
        }
    }
}