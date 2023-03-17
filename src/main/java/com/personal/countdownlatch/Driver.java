package com.personal.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Driver {
    public static void main(String[] args){

        CountDownLatch manager = new CountDownLatch(1);
        CountDownLatch worker = new CountDownLatch(10);

        new Thread(new Manager(worker, manager)).start();
        for(int i=0; i<10; i++){
            new Thread(new Worker(worker, manager), "worker-thread "+i).start();
        }
    }
}
