package org.sang.test;
/**
 * Created by will on 2018/11/23.
 */
public class warit extends Thread{

    public warit(String name){
        super(name);
    }

    private static Integer u = 0;

    public void run(){
        synchronized (u) {
            for (Integer i = 0 ;i < 10000 ; i++){
                u++;
            }
        }
    }

    public static void main(String[] args){
        warit t1 = new warit("测试多线程t1");
        warit t2 = new warit("测试多线程t2");
        try {
            t1.run();t2.run();

            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(u);

    }
}