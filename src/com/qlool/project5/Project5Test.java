package com.qlool.project5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 完结方法
 */
public class Project5Test {

    public static void main(String[] args) {
        //首先创建一个List集合：
        List<String> lists=new ArrayList<String >();
        lists.add("a1");
        lists.add("a2");
        lists.add("b1");
        lists.add("b2");
        lists.add("b3");
        lists.add("o1");

        //streamMatchTest(lists);
        //streamCollectTest(lists);
        //streamCountTest(lists);
        streamReduceTest(lists);
    }


    /**
     * 匹配（Match）
     * 用来判断某个predicate是否和流对象相匹配，最终返回Boolean类型结果.
     */
    public static void streamMatchTest(List<String> lists) {
        //流对象中只要有一个元素匹配就返回true
        boolean anyStartWithA = lists.stream().anyMatch((s -> s.startsWith("a")));
        System.out.println(anyStartWithA);
        //流对象中每个元素都匹配就返回true
        boolean allStartWithA = lists.stream().allMatch((s -> s.startsWith("a")));
        System.out.println(allStartWithA);
    }

    /**
     *收集（Collect）
     * 在对经过变换之后，我们将变换的Stream的元素收集，比如将这些元素存至集合中，此时便可以使用Stream提供的collect方法.
     */
    public static void streamCollectTest(List<String> lists) {
        List<String> list = lists.stream().filter((p) -> p.startsWith("a")).sorted().collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 计数（Count）
     * 类似sql的count，用来统计流中元素的总数.
     */
    public static void streamCountTest(List<String> lists) {
        long count = lists.stream().filter((s -> s.startsWith("a"))).count();
        System.out.println(count);
    }

    /**
     * 规约（Reduce）
     * reduce方法允许我们用自己的方式去计算元素或者将一个Stream中的元素以某种规律关联
     */
    public static void streamReduceTest(List<String> lists) {
        Optional<String> optional = lists.stream().sorted().reduce((s1, s2) -> {
            System.out.println(s1 + "|" + s2);
            return s1 + "|" + s2;
        });
    }
}
