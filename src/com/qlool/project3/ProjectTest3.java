package com.qlool.project3;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 1.Predicate接口
 * 2.Function接口
 * 3.Supplier接口
 * 4.Consumer接口
 */
public class ProjectTest3 {


    public static void main(String[] args) {
        //predicateTest();
        //functionTest();
        //supplierTest();
        consumerTest();
    }

    /**
     * 输入一个参数，并返回一个Boolean值，其中内置许多用于逻辑判断的默认方法:
     */
    public  static  void predicateTest(){
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean test = predicate.test("test");
        System.out.println("字符串长度大于0:" + test);

        test = predicate.test("");
        System.out.println("字符串长度大于0:" + test);

        test = predicate.negate().test("");
        System.out.println("字符串长度小于0:" + test);

        Predicate<Object> pre = Objects::nonNull;  //obj != null;
        Object ob = null;
        test = pre.test(ob);
        System.out.println("对象不为空:" + test);
        ob = new Object();
        test = pre.test(ob);
        System.out.println("对象不为空:" + test);
    }

    /**
     * 接收一个参数，返回单一的结果，默认的方法（andThen）可将多个函数串在一起，形成复合Funtion（有输入，有输出）结果
     */
    public static void functionTest() {
        Function<String, Integer> toInteger = Integer::valueOf;
        //toInteger的执行结果作为第二个backToString的输入
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String result = backToString.apply("1234");  //apply 将Function对象应用到输入的参数上，然后返回计算结果。
        System.out.println(result);

        Function<Integer, Integer> add = (i) -> {
            System.out.println("frist input:" + i);
            return i * 2;
        };
        Function<Integer, Integer> zero = add.andThen((i) -> {
            System.out.println("second input:" + i);
            return i * 0;
        });

        Integer res = zero.apply(8);
        System.err.println(res);
    }

    /**
     * 返回一个给定类型的结果，与Function不同的是，Supplier不需要接受参数(供应者，有输出无输入)
     */
    public static void supplierTest() {
        Supplier<String> supplier = () -> "special type value";
        String s = supplier.get();
        System.out.println(s);
    }

    /**
     * 代表了在单一的输入参数上需要进行的操作。和Function不同的是，Consumer没有返回值(消费者，有输入，无输出)
     */
    public static void consumerTest() {
        Consumer<Integer> add5 = (p) -> {
            System.out.println("old value:" + p);
            p = p + 5;
            System.out.println("new value:" + p);
        };
        add5.accept(10);
    }

}
