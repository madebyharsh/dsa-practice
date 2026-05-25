package concurrency;

public class Main {

    // create race condition
    public static int count = 0;
    static void main() throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 10000; i++){
                count++;
            }
        });
        Thread t2 = new Thread(()->{
            for(int i = 0; i < 10000; i++){
                count++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
//        start() = begin parallel work
//        run()   = normal method call
//        join()  = wait for completion
        System.out.println(count);
    }

}

