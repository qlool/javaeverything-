package com.qlool.project7;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 懒操作
 */
public class ProjectTest7{
    public static void main(String[] args) {
        Stream<Long> stream = Stream.generate(new NatureSeq());
        System.out.println("元素个数："+stream.map((param) -> {return param;}).limit(1000).count());
    }
}

//递增序列
class NatureSeq implements Supplier<Long> {
    long value = 0;

    @Override
    public Long get() {
        value++;
        return value;
    }
}