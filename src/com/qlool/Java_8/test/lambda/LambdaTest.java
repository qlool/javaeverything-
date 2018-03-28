package com.qlool.Java_8.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description : lambda java_8 Characteristics
 * @Time in 2018年3月16日 09:32:56
 * @Author By cxn
 *
 *
 * 1.使用传统迭代器和 for-each 循环的 Java 编程风格比 Java 8 中的新方式性能高很多。
 * 2.用更少的代码支持更多的动态行为
 */
public class LambdaTest {




    /**
     * 1.替代匿名内部类
     *
     * 在传统写法中，必须标注为final类型，但是lambda表达式就无需这样做，在有些时候，我们可能要重新给userId赋值，这在lambda表达式中就显得尤为有用。
     */

    /**
     * java 8之前：
     */
    public static void  olderRun(){

        final int userId=1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(userId==1){
                    System.out.println("Before Java8, too much code for too little to do"+userId);
                }
            }
        }).start();
    }

    /**
     * lambda 方式：
     */
    public static void newRun(){
        int userId=1;
        //Runnable runnable = () -> System.out.println("In Java8, Lambda expression rocks !!");
        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }


    /**
     * 2.使用lambda表达式对集合操作
     */

    /**
     * 2.0 使用lambda表达式对集合进行迭代
     */
    public static void lambdatest0(){
        List<String> languages = Arrays.asList("zhangsan","lisi","wangwu");
        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println); //// 使用方法引用 ,但如果进行操作集合中的元素的话,就不能使用方法的引用了
    }

    /**
     * 2.1 filter也是我们经常使用的一个操作。在操作集合的时候，经常需要从原始的集合中过滤掉一部分元素。
     */
    public static void filterTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0,40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));

    }

    /**
     * 2.2 有序
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
     * 2.3 并序
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
     * 3. 用lambda表达式实现map
     */
    public static void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        //将cost增加了0,05倍在相加然后输出
        Stream<Double> doubleStream = cost.stream().map(x -> x + x * 0.05);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));
    }

    /**
     * 4. 用lambda表达式实现map与reduce
     */
    public static void mapReduceTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double allCost = cost.stream().map(x -> x+x*0.05).reduce((sum,x) -> sum + x).get();
        System.out.println(allCost);
        //10.5
        //21.0
        //31.5
    }

    /**
     *  如果我们用for循环来做这件事情：
     */
    public static void sumTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        double sum = 0;
        for(double each:cost) {
            each += each * 0.05;
            sum += each;
        }
        System.out.println(sum);
    }

    //相信用map+reduce+lambda表达式的写法高出不止一个level。

    /**
     * 6. 与函数式接口Predicate配合
     * jdk8 定义:java.util.function
     * 提供predicate
     * 使用lambda表达式和函数式接口Predicate
     */
    public static void lambdatest3(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        //features.forEach(n -> System.out.println(n));
        features.forEach(System.out :: println);
    }

    public static void predicateTest(){
        List languages = Arrays.asList("Java", "a", "C++", "Haskell", "Lisp");

        System.out.println("Languages which equals with J :");
        filter(languages, (str)->str.equals("J"));

        System.out.println("Languages which equals with a : ");
        filter(languages, (str)->str.equals("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

    }

    public static void filter(List<String> names, Predicate condition) {
        for(String name: names)  {
            if(condition.test(name)) { //如果输入参数与谓词匹配，
                System.out.println(name + " ");
            }
        }
    }


    /**
     * 如何在lambda表达式中加入Predicate
     */
    public static void predicateTest1(){
        List languages = Arrays.asList("Java", "a", "C++", "Haskell", "Lisp");
            Predicate<String> eq  = n-> n.equals("Java");
            Predicate<String> start  = n-> n.startsWith("J");
            languages.stream().filter(eq.and(start)).forEach(System.out :: println);
    }
    // 类似地，也可以使用 or() 和 xor() 方法


    // collect Collectors


    public static void lambdaTest5(){
        DoubleSupplier doubleSupplier = () -> 10;
        double asDouble = doubleSupplier.getAsDouble();
        System.out.println(asDouble);

        Runnable runnable = () -> System.out.println("i");
        runnable.run();


        BinaryOperator<Integer>  add = (x, y)-> x+y;
        Integer apply = add.apply(1, 2);
        System.out.println(apply);

    }
    public static void main(String[] args) {
        //olderRun();
        //newRun();
        //lambdatest1();
        //lambdatest2();
        //lambdatest1();
        //lambdatest2();
        //mapTest();
        //sumTest();
        //mapReduceTest();
        //predicateTest();
        //predicateTest1();
        lambdaTest5();
    }

}
