package com.itersdesktop.javatechs.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BigIntAddition {
    private ArrayList<Integer> number1 = new ArrayList<>();
    private ArrayList<Integer> number2 = new ArrayList<>();
    private ArrayList<Integer> sumArray = new ArrayList<>();

    public BigIntAddition(final ArrayList<Integer> number1, final ArrayList<Integer> number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public BigIntAddition() {

    }

    public ArrayList<Integer> sum() {
        ArrayList<Integer> _longerArray = number1.size() >= number2.size() ? number1 : number2;
        ArrayList<Integer> longerArray = new ArrayList<>(_longerArray);
        Collections.reverse(longerArray);
        ArrayList<Integer> _shorterArray = number1.size() >= number2.size() ? number2 : number1;
        ArrayList<Integer> shorterArray = new ArrayList<>(_shorterArray);
        Collections.reverse(shorterArray);
        ArrayList<Integer> sumArray = getSumArray(longerArray, shorterArray);
        Collections.reverse(sumArray);
        return sumArray;
    }

    private ArrayList<Integer> getSumArray(ArrayList<Integer> longerArray, ArrayList<Integer> shorterArray) {
        Integer sum;
        Integer one;
        Integer lend = 0; // remainder

        for (int i = 0; i < longerArray.size(); i++) {
            // still in both long and short array
            if (i < shorterArray.size()) {
                sum = longerArray.get(i) + shorterArray.get(i) + lend;
                // two cases:
                // 1) sum of the two digits is not greater than 10
                // 2) both arrays are the same size and the index reached to the last digit (i.e., the left most one)
                if (sum < 10 || (i == shorterArray.size() - 1 && shorterArray.size() == longerArray.size())) {
                    one = sum;
                    lend = 0;
                } else {
                    one = sum - 10;
                    lend = 1;
                }
            } else {
                // this block handles the rest of the longer array
                // 1) the index reached the last digit
                if (i == longerArray.size() - 1) {
                    one = longerArray.get(i) + lend;
                } else {
                // 2) the index hasn't reached the last digit, so continues adding the digit to the sum array
                    one = longerArray.get(i);
                }
            }
            this.sumArray.add(one);
        }
        return sumArray;
    }

    public void test() {
        this.number1 = new ArrayList<>(Arrays.asList(2,3,4));
        this.number1 = new ArrayList<>(Arrays.asList(2,2,3,4));
        this.number1 = new ArrayList<>(Arrays.asList(7,3,4));
        this.number2 = new ArrayList<>(Arrays.asList(1,2,0,8));
        this.number2 = new ArrayList<>(Arrays.asList(8,0,8));
        this.number2 = new ArrayList<>(Arrays.asList(7,0,8));
        this.number2 = new ArrayList<>(Arrays.asList(7,9,8,3));
        this.number2 = new ArrayList<>(Arrays.asList(9,8,3));
        BigIntAddition bigIntAddition = new BigIntAddition(number1, number2);
        bigIntAddition.sum();
        bigIntAddition.print();
    }

    private void print() {
        //Stream.of(this.number1.size(), this.number2.size(), this.sumArray.size()).max(Integer::compareTo).get();
        int longestSize = Math.max(this.sumArray.size(), Math.max(this.number1.size(), this.number2.size()));
        longestSize += 15;
        System.out.printf("%" + longestSize + "s\n", number1);
        System.out.printf("%" + longestSize + "s\n", number2);
        System.out.printf("%" + longestSize + "s\n", sumArray);
    }


}
