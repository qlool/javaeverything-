package com.qlool.jdk1_8.project8;

import java.util.ArrayList;
import java.util.List;

/**
 * 效率
 */
public class ProjectTest8 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<1000000;i++)
            list.add(String.valueOf(i));

        parallelStreamTest(list);
        streamTest(list);
        foreachTest(list);

    }


    public static void parallelStreamTest(List<String> list){
        long start = System.currentTimeMillis();
        //lambda表达式 ->并行
        list.parallelStream().forEach((s)->{
            s.toString();
        });
        long end = System.currentTimeMillis();
        System.out.println("lambda表达式 ->并行 ,耗时："+(end-start) +"  ms");
    }


    public static void streamTest(List<String> list){
        long start = System.currentTimeMillis();
        //lambda表达式 ->串行
        list.stream().forEach((s)->{
            s.toString();
        });
        long end = System.currentTimeMillis();
        System.out.println("lambda表达式 ->串行 ,耗时："+(end-start) +"  ms");
    }

    public static void foreachTest(List<String> list){
        long start = System.currentTimeMillis();
        //普通测试
        for (Object s :list){
            s.toString();
        }
        long end = System.currentTimeMillis();
        System.out.println("普通测试 ,耗时："+(end-start) +"  ms");
    }
}
