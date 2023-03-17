package com.personal.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{

    CountDownLatch worker;
    CountDownLatch manager;

    public Worker(CountDownLatch worker, CountDownLatch manager) {
        this.worker = worker;
        this.manager = manager;
    }

    public void run() {
        try {
            //wait for manager to give singal
            manager.await();

            //manager has given signal, do work
            System.out.println("worked doing work :"+Thread.currentThread().getName());
            worker.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
