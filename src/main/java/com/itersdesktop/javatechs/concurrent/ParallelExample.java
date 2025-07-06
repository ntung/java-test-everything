package com.itersdesktop.javatechs.concurrent;

import java.util.Arrays;
import java.util.List;

public class ParallelExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        numbers
            .parallelStream()
            .forEach(n -> System.out.println(operate(n)));
    }

    private static String operate(final int n) {
        return "Thread: " + Thread.currentThread().getName() + " - Number: " + n;
    }
}
