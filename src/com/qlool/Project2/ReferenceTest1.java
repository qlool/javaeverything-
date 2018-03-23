package com.qlool.Project2;


/**
 * 访问局部变量
 */
public class ReferenceTest1 {
    public static void main(String[] args) {
        int n = 3;
        Calculate calculate = param -> {
            //n=10; 编译错误
            return n + param;
        };
        calculate.calculate(10);
    }


    @FunctionalInterface
    interface Calculate {
        int calculate(int value);
    }
}
