package com.qlool.Java_8.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description : lambda java_8 Characteristics
 * @Time in 2018年3月16日 09:32:56
 * @Author By cxn
 */
public class LambdaTest {

    public static void main(String[] args) {
        //olderRun();
        //newRun();
        //lambdatest1();
        //lambdatest2();
        lambdatest1();
        System.out.println("=============================");
        lambdatest2();
    }

    /**
     * 1.替代匿名内部类
     */

    /**
     * java 8之前：
     */
    public static void  olderRun(){
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
        //Runnable runnable = () -> System.out.println("In Java8, Lambda expression rocks !!");
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }


    /**
     * 2.使用lambda表达式对集合操作
     */

    /**
     * 2.1使用lambda表达式对集合进行迭代
     */
    public static void lambdatest0(){
        List<String> languages = Arrays.asList("zhangsan","lisi","wangwu");
        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
    }

    /**
     * 2.2有序
     *  filter : 是我们经常使用的一个操作。在操作集合的时候，经常需要从原始的集合中过滤掉一部分元素。
     */
    public static void lambdatest1(){
        List<Integer> names = new ArrayList<>();
        names.add(11);
        names.add(22);
        names.add(23);
        names.add(24);
        names.add(25);
        Stream<Integer> stream = names.stream();
        Stream<Integer> integerStream = stream.filter((i) -> i <= 23 && i>11);
        integerStream.forEach(System.out :: println);
    }


    /**
     * 2.3并序
     */
    public static void lambdatest2(){
        List<Integer> names = new ArrayList<>();
        names.add(11);
        names.add(22);
        names.add(23);
        names.add(24);
        names.add(25);
        Stream<Integer> stream = names.parallelStream();
        Stream<Integer> integerStream = stream.filter((i) -> i > 23);
        integerStream.forEach(System.out :: println);
        //stream.forEach(i->System.out.println(i));
        //stream.forEach(System.out :: println);
    }

    /**
     * 3.用lambda表达式实现map
     */
    public void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        //将cost增加了0,05倍的大小然后输出
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));
    }

    /**
     * 4.用lambda表达式实现map与reduce
     */

    /**
     * 6.与函数式接口Predicate配合
     */
    public static void lambdatest3(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        //features.forEach(n -> System.out.println(n));
        features.forEach(System.out :: println);
    }

}
