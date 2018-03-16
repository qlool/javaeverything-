package com.qlool.Java_8.test.lambda;

/**
 * @Description : lambda java_8 Characteristics
 * @Time in 2018年3月16日 09:32:56
 * @Author By cxn
 */
public class LambdaTest {

    public static void main(String[] args) {
        olderRun();
        newRun();
    }

    /**
     * 匿名内部类:
     */
    public static void  olderRun(){
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
    }

    /**
     * lambda 方式：
     */
    public static void newRun(){
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }

}
