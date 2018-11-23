package org.sang.test;
/**
 * Created by will on 2018/11/23.
 */
public class synchronizedTest extends Thread{

    public synchronizedTest(String name){
        super(name);
    }

    public void run(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+" run");
            //唤醒当前的wait线程
            notify();
        }
    }

    public static void main(String[] args){
        synchronizedTest t1 = new synchronizedTest("will");

        synchronized (t1) {
            //启动“线程1”
            System.out.println(Thread.currentThread().getName()+" start t1");
            t1.run();

            //主线程等待t1通过notify() 唤醒
            System.out.println(Thread.currentThread().getName()+" wait");
            try {
                t1.wait();
                System.out.println(Thread.currentThread().getName()+" continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}