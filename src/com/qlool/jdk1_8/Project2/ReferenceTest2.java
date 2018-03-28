package com.qlool.jdk1_8.Project2;

/**
 * 在Lambda表达式内部，对静态变量和成员变量可读可写
 */
public class ReferenceTest2 {
    public static int num = 2;
    public int count = 1;

    public static void test() {

        Calculate a = param -> {
            num = 10;//修改静态变量
            //return num + param+count;
            return num + param;
        };
        int calculate1 = a.calculate(10);
        System.out.println(calculate1);
    }

    public static void main(String[] args) {
        test();
    }

    interface Calculate {
        int calculate(int value);
    }

}

