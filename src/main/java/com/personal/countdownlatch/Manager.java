package com.personal.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Manager implements Runnable{

    CountDownLatch worker;
    CountDownLatch manager;

    public Manager(CountDownLatch worker, CountDownLatch manager) {
        this.worker = worker;
        this.manager = manager;
    }

    public void run() {

        System.out.println("manager has logged, going to give signal to all workers");
        manager.countDown();

        System.out.println("wait for all workers to finish");
        try {
            worker.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("all workers are done, manager doing sanity check now");
    }
}
