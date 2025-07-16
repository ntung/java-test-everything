package com.itersdesktop.javatechs.concurrent.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
    public static void main(String[] args) {
        runWorkersSequentially();
        runWorkersConcurrently();
    }

    private static void runWorkersConcurrently() {
        long time = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // wait for finishing
        }
        System.out.println("Finished all threads");
        time = (System.nanoTime() - time) / 1_000_000;
        System.out.println("It takes " + time + " milliseconds!");
    }

    private static void runWorkersSequentially() {
        long time = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            worker.run();
        }
        time = (System.nanoTime() - time) / 1_000_000;
        System.out.println("It takes " + time + " milliseconds!");
    }
}
