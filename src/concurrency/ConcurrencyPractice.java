package concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Concurrency Practice Playground
 *
 * Topics Covered:
 * 1. Race Condition
 * 2. Synchronized Fix
 * 3. Atomic Variables
 * 4. Deadlock
 * 5. Deadlock Prevention
 * 6. Producer Consumer
 * 7. CountDownLatch
 * 8. Callable + Future
 * 9. ExecutorService
 * 10. Volatile Keyword
 *
 * Uncomment methods one by one from main().
 */
public class ConcurrencyPractice {

    public static void main(String[] args) throws Exception {

//         raceConditionDemo();

         synchronizedFixDemo();

        // atomicIntegerDemo();

        // deadlockDemo();

        // deadlockPreventionDemo();

        // producerConsumerDemo();

        // countDownLatchDemo();

        // callableFutureDemo();

        // executorServiceDemo();

        // volatileDemo();
    }
    // -----------------------------------------------------------------
    // 1 - RACE Condition
    // -----------------------------------------------------------------
    static int count = 0;
    static void raceConditionDemo() throws InterruptedException {
        Runnable task = ()->{
            for(int i = 0; i < 10000; i++){
                count++;
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Expected :\t20000");
        System.out.println("Actual\t:\t"+ count);
    }

    // -----------------------------------------------------------------
    // 2 - synchronizedFixDemo
    // -----------------------------------------------------------------

    public static void increment(){
        synchronized (ConcurrencyPractice.class){ // this is same as marking method to static and synchronized means class level locking
            // for instance level locking use synchronized(this) even.
            // synchronized blocks are more preferred than method level synchronization due to other tasks gets free from locking.
            count++;
        }
    }

    public static void synchronizedFixDemo() throws InterruptedException{
        Runnable task = new Runnable(){
            @Override
            public void run(){
                for(int i = 0; i < 1000; i++){
                    increment();
                }
            }
        };

        Thread t = new Thread(task);
        t.start();
        t.join();
        System.out.println(count);
    }
}