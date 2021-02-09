package com.company;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sync {

    public static final Lock L = new ReentrantLock();

        static ArrayList<String> obj = new ArrayList<>();

        public static void testing() throws InterruptedException{


                Thread.sleep(500);
                L.lock();
                System.out.println("Unlocking...");
                L.unlock();

        }

}
