package com.qlool.jdk1_8.Project2;


/**
 *  访问局部变量 ,局部变量不能被修改
 */
public class ReferenceTest1 {

    public static void main(String[] args) {
        int n = 3;
        Calculate calculate =  param -> {
            //n=10; //编译错误
            return n + param;
        };
        System.out.println(calculate.calculate(10));



    }


    @FunctionalInterface
    interface Calculate {
        int calculate(int value);
    }
}
