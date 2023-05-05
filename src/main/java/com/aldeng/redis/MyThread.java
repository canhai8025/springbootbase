package com.aldeng.redis;

public class MyThread extends Thread{

    Service sc;
    public  MyThread(String id,int num){
        sc = new Service(id,num);
    }
    public void run(){
        while(true){
            sc.service();
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
