package com.qlool.jdk1_8.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * stream 中间方法
 */
public class Project4Test {

    public static void main(String[] args) {
        //首先创建一个List集合：
        List<String> lists=new ArrayList<String >();
        lists.add("a1");
        lists.add("a2");
        lists.add("b1");
        lists.add("b2");
        lists.add("b3");
        lists.add("o1");

        //streamFilterTest(lists);
        //streamSortedTest(lists);
        streamMapTest(lists);
    }

    /**
     * 过滤器（Filter）
     * 结合Predicate接口，Filter对流对象中的所有元素进行过滤,该操作是一个中间操作，这意味着你可以在操作返回结果的基础上进行其他操作。
     */
    public static void streamFilterTest(List<String> lists) {
        //lists.stream().filter((s -> s.startsWith("a"))).forEach(System.out::println);

        //等价于以上操作
          Predicate<String> predicate = (s) -> s.startsWith("a");
//        lists.stream().filter(predicate).forEach(System.out::println);

        //连续过滤
        Predicate<String> predicate1 = (s -> s.endsWith("1"));
        lists.stream().filter(predicate).filter(predicate1).forEach(System.out::println);
    }

    /**
     * 排序（Sorted）
     * 结合Comparator接口，该操作返回一个排序过后的流的视图，原始流的顺序不会改变。通过Comparator来指定排序规则，默认是按照自然顺序排序。
     */
    public static void streamSortedTest(List<String> lists) {
        System.out.println("默认Comparator");
        lists.stream().sorted().filter((s -> s.startsWith("a"))).forEach(System.out::println);

        System.out.println("自定义Comparator");
        lists.stream().sorted((p1, p2) -> p2.compareTo(p1)).filter((s -> s.startsWith("a"))).forEach(System.out::println);

    }

    /**
     * 映射（Map）
     * 结合Function接口，该操作能将流对象中的每个元素映射为另一种元素，实现元素类型的转换。
     */
    public static void streamMapTest(List<String> lists) {
        lists.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

        System.out.println("自定义映射规则");

        Function<String, String> function = (p) -> {
            return p + ".txt";
        };
        Stream s =  lists.stream().map(String::toUpperCase).map(function).sorted((a, b) -> b.compareTo(a));
        lists.stream().map(String::toUpperCase).map(function).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        System.out.println(lists.toString());
    }
}
