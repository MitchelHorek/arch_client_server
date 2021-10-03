package com.company;


import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.Phaser;
        import java.util.concurrent.SynchronousQueue;
        import java.util.concurrent.locks.Lock;
        import java.util.concurrent.locks.ReentrantLock;

public class PingPong implements  Runnable {

    String word;
    Object a;
    public PingPong(String word, Object a) {
        this.word = word;
        this.a = a;
    }
    public void run() {
        synchronized (a) {//синхронизация по объекту
            while (true) {
                System.out.println(word);
                try {
                    a.notifyAll();//возобновляет работу всех потоков
                    a.wait();//переводит поток в состояние ожидания
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {

        Object a = new Object();
        Runnable p1 = new PingPong("PING", a);
        Thread t1 = new Thread(p1);
        t1.start();

        Runnable p2 = new PingPong("PONG", a);
        Thread t2 = new Thread(p2);
        t2.start();

    }

}
