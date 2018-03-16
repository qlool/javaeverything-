package com.qlool.thread.test;

public class ThreadSleepTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            System.out.println("startTime = " +startTime);
            Thread.sleep(75000);
            long endTime = System.currentTimeMillis();
            System.out.println("endTime ="  +endTime);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
