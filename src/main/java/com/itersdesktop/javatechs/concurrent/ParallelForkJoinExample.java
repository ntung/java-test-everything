// https://dev.to/hugaomarques/paralelismo-e-concorrencia-102-java-parallel-streams-na-pratica-21g4
package com.itersdesktop.javatechs.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelForkJoinExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int availProcessors = Runtime.getRuntime().availableProcessors();
        int maxNbThread = availProcessors > 4 ? availProcessors /2 : 4;
        ForkJoinPool customForkJoinPool = new ForkJoinPool(maxNbThread);

        try {
            customForkJoinPool.submit(() ->
                numbers
                    .parallelStream()
                    .forEach(n -> { 
                        operate(n);
                    })
            ).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            customForkJoinPool.shutdown();
        }
        
    }

    private static void operate(final int n) {
        final String msg = "Thread: " + Thread.currentThread().getName() + " - Number: " + n;
        System.out.println(msg);
    }
}
