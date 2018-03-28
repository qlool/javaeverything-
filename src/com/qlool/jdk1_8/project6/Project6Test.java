package com.qlool.jdk1_8.project6;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @todo 并行Stream VS 串行Stream
 */
public class Project6Test {

    public static void main(String[] args) {
        //首先创建一个较大的集合：
        List<String> bigLists = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            UUID uuid = UUID.randomUUID();
            bigLists.add(uuid.toString());
        }

        notParallelStreamSortedTest(bigLists);
        parallelStreamSortedTest(bigLists);
    }

    /**
     * 测试串行流下排序所用的时间：
     * @param bigLists
     */
    private static void notParallelStreamSortedTest(List<String> bigLists) {
        long startTime = System.nanoTime();
        long count = bigLists.stream().sorted().count();
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(System.out.printf("串行排序: %d ms", millis));

    }

    /**
     * 测试并行流下排序所用的时间：
     * @param bigLists
     */
    private static void parallelStreamSortedTest(List<String> bigLists) {
        long startTime = System.nanoTime();
        long count = bigLists.parallelStream().sorted().count();
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(System.out.printf("并行排序: %d ms", millis));

    }
}
